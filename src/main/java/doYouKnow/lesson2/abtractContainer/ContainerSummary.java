package doYouKnow.lesson2.abtractContainer;

/**
 * @Author yjy
 * @Date 2023/3/27
 **/
public class ContainerSummary {
    private double amount;
    private int groupSize;

    public static final Attribute<Double, ContainerSummary> ops = Attribute.of(
            ContainerSummary::new,
            ContainerSummary::addWater,
            ContainerSummary::connectTo,
            ContainerSummary::getAmount
    );

    public ContainerSummary(double amount, int groupSize) {
        this.amount = amount;
        this.groupSize = groupSize;
    }

    public ContainerSummary() {
        this(0, 1);
    }

    public void addWater(double increment) {
        this.amount += increment;
    }

    public ContainerSummary connectTo(ContainerSummary other) {
        // 生成一个新的容器
        return new ContainerSummary(amount + other.amount, groupSize + other.groupSize);
    }

    /**
     * 返回每个容器的水量
     *
     * @return
     */
    public double getAmount() {
        return amount / groupSize;
    }


}
