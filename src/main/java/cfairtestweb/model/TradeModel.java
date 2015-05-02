package cfairtestweb.model;

public class TradeModel {

	private String userId;

	private String currencyFrom;

	private String currencyTo;

	private double amountSell;

	private double amountBuy;

	private double rate;

	private String timePlaced;

	private String originatingCountry;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public double getAmountSell() {
		return amountSell;
	}

	public void setAmountSell(double amountSell) {
		this.amountSell = amountSell;
	}

	public double getAmountBuy() {
		return amountBuy;
	}

	public void setAmountBuy(double amountBuy) {
		this.amountBuy = amountBuy;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getTimePlaced() {
		return timePlaced;
	}

	public void setTimePlaced(String timePlaced) {
		this.timePlaced = timePlaced;
	}

	public String getOriginatingCountry() {
		return originatingCountry;
	}

	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amountBuy);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(amountSell);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((currencyFrom == null) ? 0 : currencyFrom.hashCode());
		result = prime * result
				+ ((currencyTo == null) ? 0 : currencyTo.hashCode());
		result = prime
				* result
				+ ((originatingCountry == null) ? 0 : originatingCountry
						.hashCode());
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((timePlaced == null) ? 0 : timePlaced.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeModel other = (TradeModel) obj;
		if (Double.doubleToLongBits(amountBuy) != Double
				.doubleToLongBits(other.amountBuy))
			return false;
		if (Double.doubleToLongBits(amountSell) != Double
				.doubleToLongBits(other.amountSell))
			return false;
		if (currencyFrom == null) {
			if (other.currencyFrom != null)
				return false;
		} else if (!currencyFrom.equals(other.currencyFrom))
			return false;
		if (currencyTo == null) {
			if (other.currencyTo != null)
				return false;
		} else if (!currencyTo.equals(other.currencyTo))
			return false;
		if (originatingCountry == null) {
			if (other.originatingCountry != null)
				return false;
		} else if (!originatingCountry.equals(other.originatingCountry))
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (timePlaced == null) {
			if (other.timePlaced != null)
				return false;
		} else if (!timePlaced.equals(other.timePlaced))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[userId=");
		builder.append(userId);
		builder.append(", currencyFrom=");
		builder.append(currencyFrom);
		builder.append(", currencyTo=");
		builder.append(currencyTo);
		builder.append(", amountSell=");
		builder.append(amountSell);
		builder.append(", amountBuy=");
		builder.append(amountBuy);
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", timePlaced=");
		builder.append(timePlaced);
		builder.append(", originatingCountry=");
		builder.append(originatingCountry);
		builder.append("]");
		return builder.toString();
	}

}
