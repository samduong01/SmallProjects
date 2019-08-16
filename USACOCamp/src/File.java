public class File {

    public static void main(String[] args) {

        String linesOfCode[] = {
        "public class File {",
        "",
        "  public static void main(String[] args) {",
        "",
        "    String linesOfCode[] = {",
        "    };",
        "",
        "    for ( int i = 0; i < 5; i++ ) {",
        "      System.out.println( linesOfCode[i] );",
        "    }",
        "",
        "    for ( int j = 0; j < linesOfCode.length; j++ ) {",
        "      System.out.println( Character.toString((char)9) + (char)34 + linesOfCode[j] + (char)34 + (char)44 );",
        "    }",
        "",
        "    for ( int k = 5; k < linesOfCode.length; k++ ) {",
        "      System.out.println( linesOfCode[k] );",
        "    } ",
        "",
        "  } ",
        "",
        "}",
        };

        for ( int i = 0; i < 5; i++ ) {
            System.out.println( linesOfCode[i] );
        }


        for ( int j = 0; j < linesOfCode.length; j++ ) {
            System.out.println( Character.toString((char)9) + (char)34 + linesOfCode[j] + (char)34 + (char)44 );
        }

        for ( int k = 5; k < linesOfCode.length; k++ ) {
            System.out.println( linesOfCode[k] );
        }

    }

}