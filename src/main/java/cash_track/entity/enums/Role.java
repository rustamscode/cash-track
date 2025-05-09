package cash_track.entity.enums;

public enum Role {
  ROLE_USER("USER"), ROLE_ADMIN("ADMIN"), ROLE_DEVELOPER("DEVELOPER");

  private final String shortName;

  Role(String shortName) {
    this.shortName = shortName;
  }

  public String shortName() {
    return this.shortName;
  }
}
