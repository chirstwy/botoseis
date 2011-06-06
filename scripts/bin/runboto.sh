#!/bin/sh


javacmd=java
`$javacmd -cp "$BOTOSEIS_ROOT/../libs/*:$BOTOSEIS_ROOT/../dist/botoseis.jar" botoseis.mainGui.main.MainWindow`
