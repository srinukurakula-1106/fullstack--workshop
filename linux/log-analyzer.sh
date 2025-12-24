echo "=============Log Analysis Report==========="
file="C:\Users\srinu\Downloads\sample-log.txt"
total=$(wc -l "C:\Users\srinu\Downloads\sample-log.txt")
Info=$(grep -o "INFO" $file | wc -l)
warn=$(grep -o "WARNING" $file | wc -l)
error=$(grep -o "ERROR" $file | wc -l)
echo "FILE:$file"
echo "total Lines:$total"
echo "Info:" $Info
echo "warn:" $warn
echo "err:" $error
echo "-------------------------"
echo UNIQUE IP ADRESS FOUND=$(grep -oE '[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0->
echo "======================================================="

