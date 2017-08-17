package utils;

import java.util.Random;

import enums.EnemyType;

/**
 * Created by root on 17/08/17.
 */

public class RandomUtils {

    public static EnemyType getRandomEnemyType(){
        RandomEnum<EnemyType> randomEnum = new RandomEnum<EnemyType>(EnemyType.class);
        return randomEnum.random();
    }

    private static class RandomEnum<E extends Enum>{
        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token){
            values = token.getEnumConstants();
        }

        public E random(){
            return values[RND.nextInt(values.length)];
        }
    }

}
