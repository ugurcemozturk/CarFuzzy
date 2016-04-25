package carfuzzy;

import carfuzzy.CarSystem.*;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 *
 * @author ugurcem
 */
public class Rules {

    Table<Speed, Distance, Output> table = HashBasedTable.create();

    public Rules() {
        table.put(Speed.verySlow, Distance.veryClose, Output.stop);
        table.put(Speed.slow, Distance.veryClose, Output.stop);
        table.put(Speed.medium, Distance.veryClose, Output.stop);
        table.put(Speed.fast, Distance.veryClose, Output.stop);
        table.put(Speed.veryFast, Distance.veryClose, Output.stop);
        
        table.put(Speed.slow, Distance.close, Output.slowDown);
        table.put(Speed.medium, Distance.close, Output.slowDown);
        table.put(Speed.fast, Distance.close, Output.slowDown);
        table.put(Speed.veryFast, Distance.close, Output.slowDown);
        
        table.put(Speed.verySlow, Distance.close, Output.keepPace);
        table.put(Speed.medium, Distance.normal, Output.keepPace);
        table.put(Speed.fast, Distance.normal, Output.keepPace);
        table.put(Speed.veryFast, Distance.normal, Output.keepPace);
        
        table.put(Speed.verySlow, Distance.normal, Output.speedUp);
        table.put(Speed.slow, Distance.normal, Output.speedUp);
        table.put(Speed.verySlow, Distance.away, Output.speedUp);
        table.put(Speed.slow, Distance.away, Output.speedUp);
        table.put(Speed.medium, Distance.away, Output.speedUp);
        table.put(Speed.fast, Distance.away, Output.speedUp);
        table.put(Speed.veryFast, Distance.away, Output.speedUp);
    }

}
