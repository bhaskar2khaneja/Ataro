package mule.models;

public class ConfigurationModel {
  private int numOfPlayers;

  private enum Difficulty {
    BEGINNER, STANDARD, TOURNAMENT
  }

  private Difficulty difficulty;

  public enum Color {
    SALMON, BLUE, GREEN, PINK
  }

  private Color color;

  public enum Race {
    MECHTRON, GOLLUMER, PACKER, BONZOID, SPHEROID, FLAPPER, LEGGITE, HUMANOID
  }

  private Race race;

  public ConfigurationModel() {
    numOfPlayers = 1;
  }

  /**
   * Gets the number of players that are playing the game.
   */
  public int getNumOfPlayers() {
    return numOfPlayers;
  }

  /**
   * Sets the number of players that are playing the game.
   *
   * @param numOfPlayers The number of players to set.
   */
  public void setNumOfPlayers(int numOfPlayers) {
    this.numOfPlayers = numOfPlayers;
  }

  /**
   * TODO document
   */
  public Difficulty getDifficulty() {
    return difficulty;
  }

  /**
   * TODO document
   */
  public void setDifficulty(int difficultyCode) {
    switch(difficultyCode) {
      case 0:
        difficulty = Difficulty.BEGINNER;
        break;
      case 1:
        difficulty = Difficulty.STANDARD;
        break;
      case 2:
        difficulty = Difficulty.TOURNAMENT;
        break;
      default:
        break;
    }
  }

  /**
   * TODO document
   */
  public Color getColor() {
    return color;
  }

  /**
   * TODO document
   */
  public void setColor(int colorCode) {
    switch(colorCode) {
      case 0:
        color = Color.SALMON;
        break;
      case 1:
        color = Color.BLUE;
        break;
      case 2:
        color = Color.GREEN;
        break;
      case 3:
        color = Color.PINK;
        break;
      default:
        break;
    }
  }

  public Race getRace() {
      return race;
  }

  public void setRace(int raceCode) {
    switch(raceCode) {
      case 0:
        race = Race.MECHTRON;
        break;
      case 1:
        race = Race.GOLLUMER;
        break;
      case 2:
        race = Race.PACKER;
        break;
      case 3:
        race = Race.BONZOID;
        break;
      case 4:
        race = Race.SPHEROID;
        break;
      case 5:
        race = Race.FLAPPER;
        break;
      case 6:
        race = Race.LEGGITE;
        break;
      case 7:
        race = Race.HUMANOID;
        break;
    }
  }
}
