abstract class Player {
    int playerID;
    String name;
    String country;
    int[] scores;

    public Player(int playerID, String name, String country, int[] scores) {
        this.playerID=playerID;
        this.name=name;
        this.country=country;
        this.scores=scores;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public abstract void addScore(int score);

    public abstract void printDetails();
}


class Batsman extends Player {
    int runs;

    public Batsman(int playerID, String name, String country, int[] scores) {
        super(playerID, name, country, scores);
        this.runs = 0;
        for (int score : scores) {
            if (score >= 0 && score <= 100) {
                this.runs += score;
            }
        }
    }

    public int getRuns() {
        return runs;
    }

    @Override
    public void addScore(int score) {
        if (score >= 0 && score <= 100) {
            int[] newScores = new int[scores.length + 1];
            System.arraycopy(scores, 0, newScores, 0, scores.length);
            newScores[scores.length] = score;
            scores = newScores;
            this.runs += score;
        }
    }

    @Override
    public void printDetails() {
        System.out.println("----Batsman " + playerID + " Details----");
        System.out.println("Batsman ID: " + playerID);
        System.out.println("Batsman Name: " + name);
        System.out.print("Batsman Scores: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println("\nTotal Runs: " + runs);
    }
}


class Bowler extends Player {
    int wickets;

    public Bowler(int playerID, String name, String country, int[] scores) {
        super(playerID, name, country, scores);
        this.wickets = 0;
        for (int score : scores) {
            if (score >= 0 && score <= 10) {
                this.wickets += score;
            }
        }
    }

    public int getWickets() {
        return wickets;
    }

    @Override
    public void addScore(int score) {
        if (score >= 0 && score <= 10) {
            int[] newScores = new int[scores.length + 1];
            System.arraycopy(scores, 0, newScores, 0, scores.length);
            newScores[scores.length] = score;
            scores = newScores;
            this.wickets += score;
        }
    }

    @Override
    public void printDetails() {
        System.out.println("----Bowler " + playerID + " Details----");
        System.out.println("Bowler ID: " + playerID);
        System.out.println("Bowler Name: " + name);
        System.out.print("Bowler Scores: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println("\nTotal Wickets: " + wickets);
    }
}

public class Cricketplayer {
    public static void main(String[] args) {
        
        Batsman[] batsmen = {
            new Batsman(1, "Sachin Tendulkar", "India", new int[]{42, 0, 61, 15, 0, 100, 23, 64, 41, 0, 26}),
            new Batsman(2, "Virat Kohli", "India", new int[]{0, 25, 10, 60, 11, 0, 40, 11, 0, 2, 0}),
            new Batsman(3, "MS Dhoni", "India", new int[]{6, 22, 48, 0, 11, 69, 0, 21, 19, 0, 42}),
            new Batsman(4, "Ricky Ponting", "Australia", new int[]{11, 0, 28, 0, 64, 18, 45, 26, 0, 11, 0}),
            new Batsman(5, "Brian Lara", "West Indies", new int[]{0, 13, 21, 47, 0, 69, 17, 0, 12, 0, 40})
        };

        
        Bowler[] bowlers = {
            new Bowler(1, "Muttiah Muralitharan", "Sri Lanka", new int[]{0, 10, 6, 8, 0, 1, 0, 2, 4, 0, 6}),
            new Bowler(2, "Shane Warne", "Australia", new int[]{6, 0, 1, 0, 2, 0, 4, 10, 0, 6, 8}),
            new Bowler(3, "Wanindu Hasaranga", "Sri Lanka", new int[]{0, 1, 0, 6, 8, 4, 2, 0, 6, 0, 10}),
            new Bowler(4, "Glenn McGrath", "Australia", new int[]{4, 2, 6, 0, 10, 0, 1, 8, 6, 0, 0}),
            new Bowler(5, "Dale Steyn", "South Africa", new int[]{0, 4, 0, 2, 1, 6, 10, 0, 8, 6, 0})
        };

        
        batsmen[0].addScore(14);

        
        Batsman bestBatsman = batsmen[0];
        for (Batsman b : batsmen) {
            if (b.getRuns() > bestBatsman.getRuns()) {
                bestBatsman = b;
            }
        }
        System.out.println("----Find batsman with highest score----");
        bestBatsman.printDetails();

        
        Bowler bestBowler = bowlers[0];
        for (Bowler b : bowlers) {
            if (b.getWickets() > bestBowler.getWickets()) {
                bestBowler = b;
            }
        }
        System.out.println("----Find bowler with highest wickets----");
        bestBowler.printDetails();

        
        System.out.println("----Print players details from Australia----");
        System.out.println("Batsmen from Australia:");
        for (Batsman b : batsmen) {
            if (b.getCountry().equals("Australia")) {
                b.printDetails();
            }
        }

        System.out.println("Bowlers from Australia:");
        for (Bowler b : bowlers) {
            if (b.getCountry().equals("Australia")) {
                b.printDetails();
            }
        }
    }
}
