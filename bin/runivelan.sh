#!/bin/bash

cat /dev/stdin > /tmp/in_ivelan.su

javacmd=java
#javacmd=/home/williams/apps/jre1.6.0_11/bin/java

`$javacmd -cp "$BOTOSEIS_ROOT/bin/botoseis.jar" botoseis.ivelan.main.MainWindow  in=/tmp/in_ivelan.su "$@"`

#rm -f /tmp/in_ivelan.su
