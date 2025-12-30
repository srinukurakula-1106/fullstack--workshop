#!/bin/bash
# log-analyzer.sh
# Analyzes a log file and reports error, warning, and info counts
# Supports verbose mode using -v flag

# Exit immediately if any command fails
set -e

# Read arguments
LOG_FILE="$1"
VERBOSE=false

# Check for verbose flag
if [ "$2" == "-v" ]; then
    VERBOSE=true
fi

# Default log file if none provided
LOG_FILE=${LOG_FILE:-"/d/Revature_Training/01-linux/Exercises/sample_log.txt"}

# Check if log file exists
if [ ! -f "$LOG_FILE" ]; then
    echo "Error: Log file not found: $LOG_FILE"
    exit 1
fi

# Count total lines and log levels
TOTAL_LOGS=$(wc -l < "$LOG_FILE")
ERROR_COUNT=$(grep -ci "error" "$LOG_FILE")
WARN_COUNT=$(grep -ci "warning" "$LOG_FILE")
INFO_COUNT=$(grep -ci "info" "$LOG_FILE")

# Avoid division by zero
if [ "$TOTAL_LOGS" -eq 0 ]; then
    echo "No logs found."
    exit 0
fi

# Print summary
echo "================ Log Analysis Report ================"
echo "File          : $LOG_FILE"
echo "Total lines   : $TOTAL_LOGS"
echo "-----------------------------------------------------"
echo "Errors        : $ERROR_COUNT"
echo "Warnings      : $WARN_COUNT"
echo "Info          : $INFO_COUNT"
echo ""

# Verbose output
if [ "$VERBOSE" = true ]; then
    echo "============== Verbose Log Output ==================="
    while read -r line; do
        if echo "$line" | grep -iq "error"; then
            echo "[ERROR] $line"
        elif echo "$line" | grep -iq "warning"; then
            echo "[WARNING] $line"
        elif echo "$line" | grep -iq "info"; then
            echo "[INFO] $line"
        else
            echo "[OTHER] $line"
        fi
    done < "$LOG_FILE"
    echo ""
fi

# Show recent errors
echo "============== Recent Errors (Last 5) ==============="
grep -i "error" "$LOG_FILE" | tail -5
