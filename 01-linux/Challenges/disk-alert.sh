#!/bin/bash
# disk-alert.sh
# Checks disk usage and warns if usage exceeds a given threshold
# Usage: ./disk-alert.sh [THRESHOLD_PERCENT]
# Default threshold is 90%

# Exit immediately if any command fails
set -e

# Read threshold from argument or default to 90%
THRESHOLD="${1:-90}"
EXIT_CODE=0

# Use process substitution to avoid subshell issue
while read -r FS USAGE; do
  USED="${USAGE%\%}"

  if [ "$USED" -ge "$THRESHOLD" ]; then
    echo "WARNING: $FS is at ${USED}% (threshold: ${THRESHOLD}%)"
    EXIT_CODE=1
  else
    echo "OK: $FS is at ${USED}%"
  fi
done < <(df -P | awk 'NR>1 {print $1, $5}')

# Exit with appropriate status
exit "$EXIT_CODE"
