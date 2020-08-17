package minesweeper;

public class Tile {


    private final int x;
    private final int y;
    private int minesNear = 0;
    private boolean isVisible = false;
    private boolean isFlagged = false;
    private String type;

    private boolean xMinusAvailable = false;
    private boolean xPlusAvailable = false;
    private boolean yMinusAvailable = false;
    private boolean yPlusAvailable = false;
    private boolean checkedNeighborAvailability = false;

    public Tile(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void makeVisible() {
        this.isVisible = true;
    }

    public void flag() {
        this.isFlagged = true;
    }
    public void unFlag() {
        this.isFlagged = false;
    }
    public boolean isFlagged() { return this.isFlagged; }

    public void addMineNearby() {
        this.minesNear++;
    }

    public void setTypeToMinesNearby() {
        String[] englishNumberNames = {"space", "one", "two", "three", "four", "five", "six", "seven", "eight"};
        this.type = englishNumberNames[this.minesNear];
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    @Deprecated
    public char getCharCode() {
        if (isFlagged && Global.gameEnded && this.type.equals("mine")) {
            return 'X';
        }
        if (isFlagged && Global.gameEnded) {
            return '/';
        }
        if (isFlagged) {
            return 'F';
        }
        if (isVisible) {
            return switch (type) {
                case "space" -> ' ';
                case "one" -> '1';
                case "two" -> '2';
                case "three" -> '3';
                case "four" -> '4';
                case "five" -> '5';
                case "six" -> '6';
                case "seven" -> '7';
                case "eight" -> '8';
                case "mine" -> 'H';
                default -> '&';
            };
        }
        return 'o';
    }
    public String getImageCode() {
        if (isFlagged && Global.gameEnded && this.type.equals("mine")) {
            return "GoodFlag.png";
        }
        if (isFlagged && Global.gameEnded) {
            return "BadFlag.png";
        }
        if (isFlagged) {
            return "Flagged.png";
        }
        if (isVisible) {
            return switch (type) {
                case "space" -> "Tile.png";
                case "one" -> "One.png";
                case "two" -> "Two.png";
                case "three" -> "Three.png";
                case "four" -> "Four.png";
                case "five" -> "Five.png";
                case "six" -> "Six.png";
                case "seven" -> "Seven.png";
                case "eight" -> "Eight.png";
                case "mine" -> "Mine.png";
                default -> "Empty.png";
            };
        }
        return "UndiscoveredTile.png";
    }


    private void checkNeighborAvailability() {
        if (this.checkedNeighborAvailability) return;

        if (this.x != Global.sizeX - 1) this.xPlusAvailable = true;
        if (this.x != 0) this.xMinusAvailable = true;
        if (this.y != Global.sizeY - 1) this.yPlusAvailable = true;
        if (this.y != 0) this.yMinusAvailable = true;

        this.checkedNeighborAvailability = true;
    }

    public Tile[] getNeighbors() {

        checkNeighborAvailability();

        Tile[] neighbors = new Tile[8];
        int elementIndex = 0;

        if (xMinusAvailable) {
            neighbors[elementIndex] = Global.map[this.x - 1][this.y];
            elementIndex++;
            if (yPlusAvailable) {
                neighbors[elementIndex] = Global.map[this.x - 1][this.y + 1];
                elementIndex++;
            }
        }
        if (xPlusAvailable) {
            neighbors[elementIndex] = Global.map[this.x + 1][this.y];
            elementIndex++;
            if (yMinusAvailable) {
                neighbors[elementIndex] = Global.map[this.x + 1][this.y - 1];
                elementIndex++;
            }
        }
        if (yMinusAvailable) {
            neighbors[elementIndex] = Global.map[this.x][this.y - 1];
            elementIndex++;
            if (xMinusAvailable) {
                neighbors[elementIndex] = Global.map[this.x - 1][this.y - 1];
                elementIndex++;
            }
        }
        if (yPlusAvailable) {
            neighbors[elementIndex] = Global.map[this.x][this.y + 1];
            elementIndex++;
            if (xPlusAvailable) {
                neighbors[elementIndex] = Global.map[this.x + 1][this.y + 1];
            }
        }

        return neighbors;

    }
}
