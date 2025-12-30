#!/bin/bash
# user-audit.sh
# Generates a basic user audit report from system files
# Shows total users, shell users, users without passwords, and last login info

# Exit immediately if any command fails
set -e

echo "=== User Audit Report ==="

# Count total users
TOTAL_USERS=$(wc -l < /etc/passwd)
echo "Total users: $TOTAL_USERS"

# Count users with valid shell access
SHELL_USERS=$(awk -F: '$7 !~ /(false|nologin)$/ {count++} END {print count}' /etc/passwd)
echo "Users with shell access: $SHELL_USERS"

# Identify users without passwords (requires root for /etc/shadow)
echo "Users without password:"
NO_PASS_USERS=$(awk -F: '($2=="!" || $2=="") {print $1}' /etc/shadow 2>/dev/null)

COUNT_NO_PASS=0
for user in $NO_PASS_USERS; do
  echo "  - $user"
  ((COUNT_NO_PASS++))
done

echo "Users without password: $COUNT_NO_PASS"

# Display last login information for shell users
echo "Last login info for shell users:"
aw
