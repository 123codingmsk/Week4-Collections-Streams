import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MostFreqWords {
    public static void main(String[] args) {
        String textCorpus = "In the heart of a bustling city, nestled between towering skyscrapers, was a quiet little bookstore that had been open since 1942. Inside, the scent of aged paper and leather-bound covers filled the air. Each shelf was crammed with titles—some famous, others long forgotten. The owner, an elderly gentleman named Mr. Langley, had memorized the placement of every book and the name of every loyal customer.\n" +
                "\n" +
                "Outside, the world moved rapidly. Cars honked, people hurried past with their heads buried in their phones, and neon signs lit up as the sun dipped below the skyline. But inside the bookstore, time seemed to slow. College students flipped through poetry anthologies, retirees browsed history volumes, and curious travelers sought out local tales.\n" +
                "\n" +
                "Language, in all its diversity, flowed through the pages. There were stories of war and peace, of love and betrayal, of invention, science, and the stars. There were books in over a dozen languages, some featuring maps, others filled with notes scribbled by readers from decades ago. A small reading nook by the window offered a perfect spot for losing oneself in a novel on rainy afternoons.\n" +
                "\n" +
                "Meanwhile, in a distant village surrounded by forests and rivers, life followed a different rhythm. Roosters crowed with the sunrise, and the air smelled of fresh earth and blooming jasmine. Children walked to school along muddy paths, laughing and carrying handmade satchels. Elders gathered in shaded courtyards, sharing folklore over steaming cups of chai. Every face had a story, every field a history.\n" +
                "\n" +
                "In space, aboard the orbiting International Research Station, scientists conducted experiments in zero gravity. They studied the behavior of fluids, metals, and even plants in microgravity conditions. One experiment involved growing potatoes using hydroponic systems, a step toward sustaining long-term space travel. The astronauts, from various countries and cultures, shared stories and meals, orbiting Earth every 90 minutes.\n" +
                "\n" +
                "The Internet, in contrast, grew exponentially, connecting minds across continents. Blogs, videos, messages, and memes became tools of communication, education, and expression. Algorithms shaped what people saw, and artificial intelligence began writing poems, composing music, even diagnosing diseases. The lines between human and machine creativity began to blur.\n" +
                "\n" +
                "Yet in every age, in every place, language remained a powerful tool—used to build, to destroy, to question, and to dream.\n" +
                "\n" +
                "At the edge of technology and tradition, of forest and city, of Earth and the cosmos, the human story continued—unwritten, unpredictable, and full of wonder.\n";

        textCorpus = textCorpus.toLowerCase();
        String regex = "\\w+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textCorpus);
        Map<String, Integer> map = new HashMap<>();
        while(matcher.find()){
            String word = matcher.group();
            int count = map.getOrDefault(word,  0);
            map.put(word, count+1);
        }
        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(map.entrySet());
        sorted.sort((e1,e2)-> e2.getValue().compareTo(e1.getValue()));
        System.out.println("Top 10 words and their frequencies: ");
        for(int i=0; i<Math.min(10, sorted.size()); i++){
            Map.Entry<String, Integer> entry = sorted.get(i);
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

        if(sorted.size() >= 2){
            Map.Entry<String, Integer> second = sorted.get(1);
            System.out.println("Second Most frequent word: "+second.getKey());
            System.out.println("Count: "+second.getValue());
        }else{
            System.out.println("get more words");
        }
    }
}
