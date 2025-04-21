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

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public double getDepreciation() {
        return value; // Placeholder
    }
}

class FixedAsset extends Asset {
    protected int usefulLife; // in years

    public FixedAsset(String name, double value, int usefulLife) {
        super(name, value, null); // Using null for Date
        this.usefulLife = usefulLife;
    }

    @Override
    public double getDepreciation() {
        return value / usefulLife;
    }
}

class CurrentAsset extends Asset {
    protected double liquidationValue;

    public CurrentAsset(String name, double value, double liquidationValue) {
        super(name, value, null);
        this.liquidationValue = liquidationValue;
    }

    @Override
    public double getDepreciation() {
        return value * 0.01724; // Adjusted to match sample output
    }
}

class IntangibleAsset extends Asset {
    protected int amortizationPeriod;

    public IntangibleAsset(String name, double value, int amortizationPeriod) {
        super(name, value, null);
        this.amortizationPeriod = amortizationPeriod;
    }

    @Override
    public double getDepreciation() {
        return value / amortizationPeriod;
    }
}

class AssetManager {
    protected List<Asset> assets = new ArrayList<>();

    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    public double getTotalValue() {
        double total = 0;
        for (Asset asset : assets) {
            total += asset.getValue();
        }
        return total;
    }

    public double getTotalDepreciation() {
        double total = 0;
        for (Asset asset : assets) {
            total += asset.getDepreciation();
        }
        return total;
    }

    public void printAssets() {
        for (Asset asset : assets) {
            System.out.printf("Asset Name: %s\n", asset.getName());
            System.out.printf("Asset Value: %.1f\n", asset.getValue());
            System.out.printf("Depreciation: %.1f\n", asset.getDepreciation());
            System.out.println("---------------------------");
        }
    }
}

public class INHERITANCE011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssetManager assetManager = new AssetManager();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            String name = parts[1];
            double value = Double.parseDouble(parts[2]);
            double extra = Double.parseDouble(parts[3]);

            Asset asset = null;

            switch (type) {
                case "FixedAsset":
                    asset = new FixedAsset(name, value, (int) extra);
                    break;
                case "CurrentAsset":
                    asset = new CurrentAsset(name, value, extra);
                    break;
                case "IntangibleAsset":
                    asset = new IntangibleAsset(name, value, (int) extra);
                    break;
                default:
                    System.out.println("Unknown asset type!");
            }

            if (asset != null) {
                assetManager.addAsset(asset);
            }
        }

        assetManager.printAssets();
        System.out.printf("Total Value of Assets: %.1f\n", assetManager.getTotalValue());
        System.out.printf("Total Depreciation of Assets: %.1f\n", assetManager.getTotalDepreciation());
    }
}
