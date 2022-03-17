package lab3;

public interface Storage {
    enum storageUnit {
        megabyte,
        kilobyte,
        Byte
    }

    int getStorageCapacity();

    default int getStorageCapacity(storageUnit unit) {
        int capacity = getStorageCapacity();
        if(unit == storageUnit.megabyte)
            return capacity * 1000;
        if(unit == storageUnit.kilobyte)
            return capacity * 1000000;
        if(unit == storageUnit.Byte)
            return capacity * 1000000000;
        return capacity;
    }

}
