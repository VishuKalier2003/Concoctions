import java.util.*;
public class Spells
{
    public int[] SuccessfulPairs(int spells[], int potions[], long success)
    {
        int pairs[] = new int[spells.length];
        Arrays.sort(potions);     // Sorting the potions in increasing order...
        for(int i = 0; i < spells.length; i++)
        {
            int start = 0, end = potions.length-1, index = -1;   // Variables for Binary Search...
            while(start <= end)    // While we haven't traversed the end...
            {
                int mid = (int)((start + end)/2);   
                if((long)spells[i] * (long)potions[mid] >= success)
                {
                    index = mid;    // Updating the index, below which the concoctions are unsuccessful...
                    end = mid - 1;   // We check the left array...
                }
                else
                    start = mid + 1;    // Otherwise we check the right array...
            }
            pairs[i] = index == -1 ? 0 : potions.length-index;    // Using ternary operators...
        }
        return pairs;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of Spells : ");
        x = sc.nextInt();
        int spell[] = new int[x];
        System.out.print("Enter the number of potions : ");
        int potions[] = new int[x];
        for(int i = 0; i < spell.length; i++)
        {
            System.out.print("Enter the strength of "+(i+1)+" th Spell : ");
            spell[i] = sc.nextInt();
        }
        for(int i = 0; i < potions.length; i++)
        {
            System.out.print("Enter the strength of "+(i+1)+" th Potion : ");
            potions[i] = sc.nextInt();
        }
        long power;
        System.out.print("Enter the minimum power of a pair to be successful : ");
        power = sc.nextLong();
        Spells spells = new Spells();    // Object creation...
        int successful[] = spells.SuccessfulPairs(spell, potions, power);   // Function call...
        for(int i = 0; i < successful.length; i++)
            System.out.print(successful[i]+", ");
        sc.close();
    }
}

// Time Complexity  - O(n log m + m log n) time...
// Space Complexity - O(n) space...