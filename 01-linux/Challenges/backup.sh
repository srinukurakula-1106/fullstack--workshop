#!/bin/bash
# backup.sh
# Creates a compressed backup of a source directory
# Keeps only the latest 5 backup files

# Exit immediately if any command fails
set -e

# Read command-line arguments
SRC="$1"
DEST="$2"

# Validate arguments
if [ -z "$SRC" ] || [ -z "$DEST" ]; then
  echo "Usage: $0 /path/to/source /path/to/backup-dest"
  exit 1
fi

# Check if source directory exists
if [ ! -d "$SRC" ]; then
  echo "Error: Source directory does not exist"
  exit 1
fi

# Create destination directory if it does not exist
mkdir -p "$DEST"

# Generate timestamp for unique backup name
TIMESTAMP=$(date "+%Y%m%d-%H%M%S")
BACKUP_FILE="$DEST/backup-$TIMESTAMP.tar.gz"

# Create compressed backup
tar -czf "$BACKUP_FILE" -C "$SRC" .

# Remove old backups, keep only the latest 5
ls -1t "$DEST"/backup-*.tar.gz | tail -n +6 | xargs -r rm --

# Get backup size
SIZE=$(du -h "$BACKUP_FILE" | cut -f1)

# Print success message
echo "Backup completed successfully"
echo "Backup file : $BACKUP_FILE"
echo "Backup size : $SIZE"
