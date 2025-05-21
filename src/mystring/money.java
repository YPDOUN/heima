package mystring;

/*
    金额转换大小写
    零、壹、贰、叁、肆、伍、陆、柒、捌、玖
 */
public class money {
    public static void main(String[] args) {
        int[] arr = {5,6,7};
        StringBuilder sb = new StringBuilder();

        int count = 7 - arr.length;
        for(int i = 0; i < count; i++){
            sb.append(toUpper(0));
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(toUpper(arr[i]));
        }

        String s = sb.toString();
        String str = "";
        for(int i = 0; i < s.length(); i++){
            str = str + s.charAt(i) + unit(i);
        }
        System.out.println(str);
    }

    public static char toUpper(int index){
         String str = "零壹贰叁肆伍陆柒捌玖";
         return str.charAt(index);
    }

    public static String unit(int index){
        String[] str = {"佰","拾","万", "仟","佰", "拾", "元"};
        return str[index];
    }
}