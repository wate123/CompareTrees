package comparetrees;
/**
 * Tracks a word and its frequency.
 * @author William Duncan
 * @since 99-99-9999
 */

public class WordStat implements Comparable<WordStat>
{
    /**
     * a word
     */
    private String word;
    /**
     * the frequency of this word
     */
    private int count;
   
   /**
      Constructor
     * @param aWord a word
     * @param aCount the frequency of the specified word
   */
   public WordStat(String aWord, int aCount)
   {
      word = aWord;
      count = aCount;
   }
  
   /**
      Returns a word
     * @return the word
   */
   public String getWord()
   {
      return word;
   }

   /**
      Returns a word
     * @return a word
   */
   public long getCount()
   {
      return count;
   }

   /**
    * Updates the frequency of a word by the specified number.
     * @param increment the number by which the frequency is increased.
   */
   public void updateCount(int increment)
   {
      count = count + increment;
   }
   
   /**
    * Determines whether this object contains the same word as the specified object.
    * @param another an object of this class
    * @return -1 if the word in this object come before the word in the specified object,
    * 1 if it comes after, and 0 if they are the same
    * false, otherwise
    */
   public int compareTo(WordStat another)
   {
      return word.compareTo(another.word);
   }
}