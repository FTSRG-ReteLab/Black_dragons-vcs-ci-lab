package hu.bme.mit.train.system;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Tachograph {
    Table<Integer,Integer,Integer> table = HashBasedTable.create();

    void newRecord(int time, int position, int speed) {
        table.put(time,position,speed);
    }
    int getSize() {
        return table.size();
    }
}
