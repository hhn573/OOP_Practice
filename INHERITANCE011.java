import java.util.*;

abstract class Asset {
    protected String name;
    protected double value;

    public Asset(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public abstract double getDepreciation();
}

class FixedAsset extends Asset {
    private int usefulLife;

    public FixedAsset(String name, double value, int usefulLife) {
        super(name, value);
        this.usefulLife = usefulLife;
    }

    @Override
    public double getDepreciation() {
        return value / usefulLife;
    }
}

class CurrentAsset extends Asset {
    private double liquidationValue;

    public CurrentAsset(String name, double value, double liquidationValue) {
        super(name, value);
        this.liquidationValue = liquidationValue;
    }

    @Override
    public double getDepreciation() {
        return value * 0.1; 
    }
}

class IntangibleAsset extends Asset {
    private int amortizationPeriod;

    public IntangibleAsset(String name, double value, int amortizationPeriod) {
        super(name, value);
        this.amortizationPeriod = amortizationPeriod;
    }

    @Override
    public double getDepreciation() {
        return value / amortizationPeriod;
    }
}

class AssetManager {
    private List<Asset> assets = new ArrayList<>();

    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    public double getTotalValue() {
        return assets.stream().mapToDouble(Asset::getValue).sum();
    }

    public double getTotalDepreciation() {
        return assets.stream().mapToDouble(Asset::getDepreciation).sum();
    }

    public void printAssets() {
        for (Asset asset : assets) {
            System.out.printf("Asset Name: %s%n", asset.getName());
            System.out.printf("Asset Value: %.1f%n", asset.getValue());
            System.out.printf("Depreciation: %.1f%n", asset.getDepreciation());
            System.out.println("---------------------------");
        }
    }
}

public class INHERITANCE011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        AssetManager assetManager = new AssetManager();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            String type = parts[0];
            String name = parts[1];
            double value = Double.parseDouble(parts[2]);
            double extra = Double.parseDouble(parts[3]);

            Asset asset = switch (type) {
                case "FixedAsset" -> new FixedAsset(name, value, (int) extra);
                case "CurrentAsset" -> new CurrentAsset(name, value, extra);
                case "IntangibleAsset" -> new IntangibleAsset(name, value, (int) extra);
                default -> {
                    System.out.println("Unknown asset type!");
                    yield null;
                }
            };

            if (asset != null) assetManager.addAsset(asset);
        }

        assetManager.printAssets();
        System.out.printf("Total Value of Assets: %.1f%n", assetManager.getTotalValue());
        System.out.printf("Total Depreciation of Assets: %.1f%n", assetManager.getTotalDepreciation());
    }
}
