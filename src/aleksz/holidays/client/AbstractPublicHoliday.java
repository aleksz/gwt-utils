package aleksz.holidays.client;

public abstract class AbstractPublicHoliday implements PublicHoliday {

  protected final Integer yearOfFirstOccurance;
  protected final Integer yearOfLastOccurance;
  private String name;
  private String[] countryCodes;

  protected AbstractPublicHoliday(String name, Integer yearOfLastOccurance,
      String... countryCodes) {
    this(name, 1970, yearOfLastOccurance, countryCodes);
  }

  protected AbstractPublicHoliday(String name, Integer yearOfFirstOccurance,
      Integer yearOfLastOccurance, String... countryCodes) {
    this.name = name;
    this.yearOfFirstOccurance = yearOfFirstOccurance;
    this.yearOfLastOccurance = yearOfLastOccurance;
    this.countryCodes = countryCodes;
  }

  protected boolean yearDoesNotFit(int year) {

    if (yearOfFirstOccurance != null && year < yearOfFirstOccurance) {
      return true;
    }

    if (yearOfLastOccurance != null && year > yearOfLastOccurance) {
      return true;
    }

    return false;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String[] getCountryCodes() {
    return countryCodes;
  }

  @Override
  public boolean isGlobal() {
    return countryCodes == null || countryCodes.length == 0;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    AbstractPublicHoliday other = (AbstractPublicHoliday) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
}
