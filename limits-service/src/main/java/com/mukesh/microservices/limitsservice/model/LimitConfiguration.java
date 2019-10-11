package com.mukesh.microservices.limitsservice.model;

/**
 * @author mukeshgehani
 *
 */
public class LimitConfiguration {

	private int maximum;
	private int minimum;

	protected LimitConfiguration() {

	}

	/**
	 * @param maximum
	 * @param minimum
	 */
	public LimitConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	/**
	 * @return the maximum
	 */
	public int getMaximum() {
		return maximum;
	}

	/**
	 * @param maximum
	 *            the maximum to set
	 */
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	/**
	 * @return the minimum
	 */
	public int getMinimum() {
		return minimum;
	}

	/**
	 * @param minimum
	 *            the minimum to set
	 */
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maximum;
		result = prime * result + minimum;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LimitConfiguration other = (LimitConfiguration) obj;
		if (maximum != other.maximum)
			return false;
		if (minimum != other.minimum)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LimitConfiguration [maximum=");
		builder.append(maximum);
		builder.append(", minimum=");
		builder.append(minimum);
		builder.append("]");
		return builder.toString();
	}

}
