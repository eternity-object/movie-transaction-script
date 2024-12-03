package org.eternity.script.generic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void plus() {
        Money won1000 = Money.wons(1000);
        Money won2000 = Money.wons(2000);
        Money won3000 = won1000.plus(won2000);

        assertThat(Money.wons(3000)).isEqualTo(won3000);
        assertThat(Money.wons(1000)).isEqualTo(won1000);
        assertThat(Money.wons(2000)).isEqualTo(won2000);
    }

    @Test
    public void minus() {
        Money won3000 = Money.wons(3000);
        Money won2000 = Money.wons(2000);
        Money won1000 = won3000.minus(won2000);

        assertThat(Money.wons(1000)).isEqualTo(won1000);
        assertThat(Money.wons(3000)).isEqualTo(won3000);
        assertThat(Money.wons(2000)).isEqualTo(won2000);
    }

    @Test
    public void times() {
        Money won1000 = Money.wons(1000);
        Money won2000 = won1000.times(2);

        assertThat(Money.wons(2000)).isEqualTo(won2000);
        assertThat(Money.wons(1000)).isEqualTo(won1000);
    }

    @Test
    public void divideBy() {
        Money won2000 = Money.wons(2000);
        Money won1000 = won2000.divide(2);

        assertThat(Money.wons(1000)).isEqualTo( won1000);
        assertThat(Money.wons(2000)).isEqualTo(won2000);
    }

    @Test
    public void isLessThan() {
        Money won1000 = Money.wons(1000);
        Money won2000 = Money.wons(2000);

        assertThat(won1000.isLessThan(won2000)).isTrue();

    }

    @Test
    public void isGreaterThanOrEqual() {
        Money won1000 = Money.wons(1000);
        Money won2000 = Money.wons(2000);

        assertThat(won2000.isGreaterThanOrEqual(won2000)).isTrue();
    }
}
