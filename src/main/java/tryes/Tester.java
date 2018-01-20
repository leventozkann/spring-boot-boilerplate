package tryes;

import java.io.IOException;
import java.util.Scanner;

public class Tester {
	
    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
    static String[] twins(String[] a, String[] b) 
    {
        String[] veri = new String[a.length];
        for (int i = 0; i < a.length; i++)
        {
            char[] text = a[i].toCharArray();
            int sayi = 0;
            for (int j = 0; j < text.length; j++)
            {

                if (sayi<2)
                {
                    char temp = text[j];
                    text[j] = text[j + 2];
                    text[j + 2] = temp;                        
                }
                else if (sayi==4) 
                {
                    sayi=0;
                }

                sayi++;
            }
            String str = "";
            for (int k = 0; k < text.length; k++)
            {
                str += text[k];
            }
            veri[i] = str;
        }

        String[] sonuc = new String[2];
        for (int l = 0; l < b.length; l++)
        {
            if (veri[l] == b[l])
            {
                sonuc[l] = "Yes";
            }
            else
            {
                sonuc[l] = "No";
            }
        }


        return sonuc;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        String[] res;
        
        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        String[] _a = new String[_a_size];
        String _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            try {
                _a_item = in.nextLine();
            } catch (Exception e) {
                _a_item = null;
            }
            _a[_a_i] = _a_item;
        }
        
        
        int _b_size = 0;
        _b_size = Integer.parseInt(in.nextLine().trim());
        String[] _b = new String[_b_size];
        String _b_item;
        for(int _b_i = 0; _b_i < _b_size; _b_i++) {
            try {
                _b_item = in.nextLine();
            } catch (Exception e) {
                _b_item = null;
            }
            _b[_b_i] = _b_item;
        }
        
        res = twins(_a, _b);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
}