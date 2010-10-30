#!/bin/sh

#export BOTOSEIS_ROOT=/home/gabriel/BOTOSEIS_ROOT

javacmd=java
#javacmd=/home/williams/apps/jre1.6.0_11/bin/java
`$javacmd -cp "$BOTOSEIS_ROOT/bin/botoseis.jar" botoseis.iview.main.MainWindow $*`
#`$javacmd -jar /nis/gabriel/NetBeansProjects/botoseis/dist/botoseis.jar`
