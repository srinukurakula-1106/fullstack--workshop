#!/bin/bash
# process-monitor.sh
# Monitors a process and alerts if it stops running
# Usage: ./process-monitor.sh <process_name> <interval_in_seconds>

# Exit immediately if any command fails
set -e

# Read command-line arguments
PROCESS="$1"
INTERVAL="$2"

# Validate arguments
if [ -z "$PROCESS" ] || [ -z "$INTERVAL" ]; then
  echo "Usage: $0 process_name interval_in_seconds"
  exit 1
fi

echo "Monitoring process: $PROCESS"

# Infinite monitoring loop
while true; do
  TIMESTAMP=$(date "+%Y-%m-%d %H:%M:%S")

  # Check if process is running (Linux-compatible)
  if pgrep -i "$PROCESS" > /dev/null; then
    echo "[$TIMESTAMP] $PROCESS is running"
  else
    echo "[$TIMESTAMP] ALERT: $PROCESS has stopped"
    exit 0
  fi

  # Wait before next check
  sleep "$INTERVAL"
done
