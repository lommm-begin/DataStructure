package com.example;

public interface GraphContent {

    default Graph createUDN(int vexNum, int arcNum) {
        return null;
    }

    default int locateVex(GraphContent graphContent, char vexNum) {
        return -1;
    }
}
