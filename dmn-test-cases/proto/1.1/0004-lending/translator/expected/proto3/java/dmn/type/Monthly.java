package type;

import java.util.*;

@javax.annotation.Generated(value = {"itemDefinitionInterface.ftl", "Monthly"})
@com.fasterxml.jackson.annotation.JsonPropertyOrder(alphabetic = true)
@com.fasterxml.jackson.databind.annotation.JsonDeserialize(as = type.MonthlyImpl.class)
public interface Monthly extends com.gs.dmn.runtime.DMNType {
    static Monthly toMonthly(Object other) {
        if (other == null) {
            return null;
        } else if (Monthly.class.isAssignableFrom(other.getClass())) {
            return (Monthly)other;
        } else if (other instanceof com.gs.dmn.runtime.Context) {
            MonthlyImpl result_ = new MonthlyImpl();
            result_.setIncome((java.math.BigDecimal)((com.gs.dmn.runtime.Context)other).get("Income"));
            result_.setExpenses((java.math.BigDecimal)((com.gs.dmn.runtime.Context)other).get("Expenses"));
            result_.setRepayments((java.math.BigDecimal)((com.gs.dmn.runtime.Context)other).get("Repayments"));
            return result_;
        } else if (other instanceof com.gs.dmn.runtime.DMNType) {
            return toMonthly(((com.gs.dmn.runtime.DMNType)other).toContext());
        } else if (other instanceof proto.Monthly) {
            MonthlyImpl result_ = new MonthlyImpl();
            result_.setIncome(java.math.BigDecimal.valueOf(((proto.Monthly) other).getIncome()));
            result_.setExpenses(java.math.BigDecimal.valueOf(((proto.Monthly) other).getExpenses()));
            result_.setRepayments(java.math.BigDecimal.valueOf(((proto.Monthly) other).getRepayments()));
            return result_;
        } else {
            throw new com.gs.dmn.runtime.DMNRuntimeException(String.format("Cannot convert '%s' to '%s'", other.getClass().getSimpleName(), Monthly.class.getSimpleName()));
        }
    }

    static proto.Monthly toProto(Monthly other) {
        proto.Monthly.Builder result_ = proto.Monthly.newBuilder();
        if (other != null) {
            Double incomeProto_ = (((Monthly) other).getIncome() == null ? 0.0 : ((Monthly) other).getIncome().doubleValue());
            result_.setIncome(incomeProto_);
            Double expensesProto_ = (((Monthly) other).getExpenses() == null ? 0.0 : ((Monthly) other).getExpenses().doubleValue());
            result_.setExpenses(expensesProto_);
            Double repaymentsProto_ = (((Monthly) other).getRepayments() == null ? 0.0 : ((Monthly) other).getRepayments().doubleValue());
            result_.setRepayments(repaymentsProto_);
        }
        return result_.build();
    }

    static List<proto.Monthly> toProto(List<Monthly> other) {
        if (other == null) {
            return null;
        } else {
            return other.stream().map(o -> toProto(o)).collect(java.util.stream.Collectors.toList());
        }
    }

    @com.fasterxml.jackson.annotation.JsonGetter("Income")
    java.math.BigDecimal getIncome();

    @com.fasterxml.jackson.annotation.JsonGetter("Expenses")
    java.math.BigDecimal getExpenses();

    @com.fasterxml.jackson.annotation.JsonGetter("Repayments")
    java.math.BigDecimal getRepayments();

    default com.gs.dmn.runtime.Context toContext() {
        com.gs.dmn.runtime.Context context = new com.gs.dmn.runtime.Context();
        context.put("income", getIncome());
        context.put("expenses", getExpenses());
        context.put("repayments", getRepayments());
        return context;
    }

    default boolean equalTo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Monthly other = (Monthly) o;
        if (this.getExpenses() != null ? !this.getExpenses().equals(other.getExpenses()) : other.getExpenses() != null) return false;
        if (this.getIncome() != null ? !this.getIncome().equals(other.getIncome()) : other.getIncome() != null) return false;
        if (this.getRepayments() != null ? !this.getRepayments().equals(other.getRepayments()) : other.getRepayments() != null) return false;

        return true;
    }

    default int hash() {
        int result = 0;
        result = 31 * result + (this.getExpenses() != null ? this.getExpenses().hashCode() : 0);
        result = 31 * result + (this.getIncome() != null ? this.getIncome().hashCode() : 0);
        result = 31 * result + (this.getRepayments() != null ? this.getRepayments().hashCode() : 0);
        return result;
    }

    default String asString() {
        StringBuilder result_ = new StringBuilder("{");
        result_.append("Expenses=" + getExpenses());
        result_.append(", Income=" + getIncome());
        result_.append(", Repayments=" + getRepayments());
        result_.append("}");
        return result_.toString();
    }
}
