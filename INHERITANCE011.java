import java.util.*;

class Asset {
    protected String name;
    protected double value;
    protected Date acquisitionDate;

    public Asset(String name, double value, Date acquisitionDate) {
        this.name = name;
        this.value = value;
        this.acquisitionDate = acquisitionDate;
    }

    public double getDepreciation() {
        return value; // Example depreciation calculation
    }
}

class FixedAsset extends Asset {
    protected  int usefulLife; // in years

    public FixedAsset(String name, double value, Date acquisitionDate, int usefulLife) {
        super(name, value, acquisitionDate);
        this.usefulLife = usefulLife;
    }

    @Override
    public double getDepreciation() {
        // Example depreciation calculation for fixed assets
        return value / usefulLife;
    }
}

class CurrentAsset extends Asset {
    protected  double liquidationValue; // Current market value

    public CurrentAsset(String name, double value, Date acquisitionDate, double liquidationValue) {
        super(name, value, acquisitionDate);
        this.liquidationValue = liquidationValue;
    }

    @Override
    public double getDepreciation() {
        // Example depreciation calculation for current assets
        return value * 0.1;
    }
}

class IntangibleAsset extends Asset {
    protected int amortizationPeriod;

    public IntangibleAsset(String name, double value, Date acquisitionDate, int amortizationPeriod) {
        super(name, value, acquisitionDate);
        this.amortizationPeriod = amortizationPeriod;
    }

    @Override
    public double getDepreciation() {
        // Example depreciation calculation for intangible assets
        return value / amortizationPeriod;
    }   
}

class AssetManager {
    
}

public class INHERITANCE011 {
    public static void main(String[] args) {

    }    
}
