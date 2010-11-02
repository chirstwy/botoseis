#!/bin/sh

export BOTOSEIS_ROOT=/home/gabriel/NetBeansProjects/botoseis/scripts
export PATH=$PATH:$BOTOSEIS_ROOT/bin

javacmd=java
`$javacmd -cp "$BOTOSEIS_ROOT/../dist/botoseis.jar" botoseis.mainGui.main.MainWindow`
