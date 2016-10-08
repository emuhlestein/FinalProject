package com.intelliviz.java;

public class JokeGenerator {
    public String getJoke(int i, int type) {
        if(type == 0) {
            return "you only get this one lame joke";
        } else {
            switch(i) {
                case 0:
                return "What is the phone number of the garden of Eden?\n\n"
                        + "a*d*a*m*8*1*2";
                case 1:
                    return "Who was the greatest finacier in the Bible?\n\n"
                            + "Noah. He floated is stock while the rest of the world was in liquidation.";
                case 2:
                    return "Who was the greatest entertainer in the Bible?\n\n"
                            + "Samson. He brought down the house...\n"
                            + "The only man to die of fallen arches.";
                case 3:
                    return "When were sports mentioned in the Bible?\n\n"
                            + "In the big inning.";
                case 4:
                    return "When were sports mentioned in the Bible?\n\n"
                            + "When Racheal walked to the wall with the pitcher.";
                case 5:
                    return "When were motorcycles mentioned in the Bible?\n\n"
                            + "When the roar of Pharoah's triumph was hear throughout the land.";
                default:
                    return "not a valid joke.";
            }
        }
    }
}
