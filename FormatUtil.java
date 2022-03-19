// 按照编码格式截取字节长度 避免中文乱码

public static String subStr(String str, int subSLength)    {
        String  subStr ="";
        try {
            if (str == null) return "";
            else{
                int tempSubLength = subSLength;//截取字节数
                subStr = str.substring(0, str.length()<subSLength ? str.length() : subSLength);//截取的子串
                int subStrByetsL = subStr.getBytes(StandardCharsets.UTF_8).length;//截取子串的字节长度
                // 说明截取的字符串中包含有汉字
                while (subStrByetsL > tempSubLength){
                    int subSLengthTemp = --subSLength;
                    subStr = str.substring(0, subSLengthTemp>str.length() ? str.length() : subSLengthTemp);
                    subStrByetsL = subStr.getBytes(StandardCharsets.UTF_8).length;
                }
            }
            throw new Exception();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return subStr;
    }
