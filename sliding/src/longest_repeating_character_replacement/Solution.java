package longest_repeating_character_replacement;

public class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0, left = 0;
        int[] cache = new int[26];

        for (int right = 0; right < s.length(); right++) {
            cache[s.charAt(right) - 'A'] += 1;

            while ((right - left + 1) - findMostRepeatedCharacterCount(cache) > k) {
                cache[s.charAt(left) - 'A'] -= 1;
                left += 1;
            }

            result = Math.max(result, right - left + 1);
        }


        return result;
    }

    private int findMostRepeatedCharacterCount(int[] cache) {
        int result = 0;

        for (int count : cache) {
            if (count > result)
                result = count;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        result = instance.characterReplacement("CAAFDAEFFAEECBDFDFAECACBDADDEEFFCDEDBDDEDDEAFEFFCCFDDEFBBABAEACCADFEEBAFFBCBDADCCCAFAFBFCCACBDDBDEFECCDDEECBDEFEDCEDEFFACFFCFEFCCBDCBAEDEBBCDBECCFEDEDBDFAEFBCEFEFECBFCBBAFBAFDFCDCEBAFFDFFABCCABDDAEEEFDFCDECEBEEBCCECACEECBCBBEDBBECAAFDEAADCBDAADCDDFBDDCCFACACBBCDFBCBEFDCAFDBACFCEAAFDEBCDCCFFCEFFECECBFABFACCBACAEFEDCECCFBCCBEDECCBAFDDBEDDABDDADEFADDCDABDDBEECDDDCBDDABECCBBFDBBBCDBFCACBBFFBBBDFDDFFCBBEEAEFEDECAFEDACABAEEAAAFEBEBAEFEACEECEFDECBEDCEFDDFCACFCCDCFBBEBAFABECCACDFBBDFEEDABFEFFFDFFDCCFDAFCFEFBBABCBCFABEBBFDABEAEFDAFDDBFAEBCEEADBAFDBDFBAEACEDADCDADDCDEBBAFBBEEBFFDACCAFFFCCFEEADFECAFBEBCDFADCCECFEEBDFBDEBFEFEEAEEADCECBFEDFBCDEADDFFFDCDFAFCAECBBBBDBAFEBBBEEDABCEDECABDCFBEBAFCEFBECDACEFEBFCEDFCDBBCBFCCBCAACEFDBCDFDDEACAFADCAAEFAAEAECFBAFFFEAFFBCDBEFFEFDDECEEACACFEDFFBDEDCCDDEBEBBDDAAFCCAAADCEBEECFADFEECDDAAFCFDADBBCECADDBEEAEEFBEDBBADAFEAFFBDAEFCBCCBABDEFFADEBEBCEBEBDCECEDCFCEECFBAEEDFBAEDAECEDDCFEEEAEABDDDDBCBABABCBEDDABCEFACBCAFBCFBDFFAEAFDFBAAFDFAECCACBFEAAEDBAFADCADFCBAACBFECFFBDDEDCCBFDFFBCAADDAABEECDBDEFEFABABDDABACCADFFECBAEAFCEBFFAEFCDFACAEBFFCFAFBEFBDACECECFCFABFBEEFFADBDEECADEFAFAECBFDCADFFDFDEADFEBFDBBBDAEEBBDBDBFDEDFDCAAEFBADEDABEECABAACAFFACBBDEECDDDDAAACCBADCCBECACCBEEDBABCDEBFBFECDFEFFCDEFBEFDACDEAADBECBBCBCACEFDECFCACDDABDBAFFDCAFDADDEDBDEEEFBCFEACCBDEFCEFECCCEECBDADBCDBBDEFEDEAEDCEFBAAEACBEDBFFFADCDDFEFFBBACEECBBBBCCDDEEAEAEDEBCADFABDEBBFEEAADBCBFACDDACBDDFFFAEECEFBBDABBADDDDCBCFAAEABFFABCFAADDCFDDDDFEDAFFEEEBBBEEACACDECEDECCAFDECDADBDAFCBCAAEAEECCCCBAFABFADFEABFEABFDAADCCECABDCECEAFAEDAFCDDEABCDBCDCCAEBFDDFCBDBDCEEBBDFCCDADEDCADCCCBEBFCEFACDFCFDBDDFBCBDBACFEECCEBECEBEABDCDCDAFAEBECEFBFABCDDBDFFBAFCFDACEFECABDECFECFBCCFFFEEDAABABDECDBABFCDEFBBAACDEFAEABCDDEAECDFFCFFACFBAFFBBAFDFFAAAFCBCAEACEDFDDEBEBABEFCABACECCFAAECAAEBFFBDADEAAFBADDACFEFBCDCDDEBBAADEEEEFBFCEDDFAAEEFEADEECCADBECAABEECBAFECAFAACFEADBDCBDBCDEDABEBBDAFBDBCBCAFFBBDBDDABBBAEFBADDCBADFFEFFBDFEFDCAAEBFCDABFEFBBADFDBACBEDBABBBBDCCDFDDEBFBADBDDFAABCFDEECCFDBCDACDCDBBEEEEDCAECABAAEFEDAACCDFDCDECFCAEADBFFABCBEAABCCDEEDFBABFDBBCCFDFDDCEBFDCDEBCDAEFCBCEDACACEDEADCEEFBBEEBCCAAADCCFDEBFEEDCDEBEFFECEAFDBCBDCBACEFDBEAFBCCCFECFDEEAFCBEDAAFFFAADFBFFBCAAEEDBAEAADFAFDEAEBEBEEBCAEDCACCBDDDDCBBBABDEAAFEFAFFEDBDEEEACFFFAEBABADEACCDEAFCCCEDCCBABEECEFAEACADDDDBEACEBEFDEEDDBAEEEACDBBBFADCAACDDFACFFAFAECFABADFDDCAFEDECDEDCEABDEFFEFBDECDACDCAECCECCCBCEABBFACDBFDFCECCEFCCEEEABFDDBBFBEDBBAEACEEFDBFFFEECFABBAAEBFBCDECCFCFACBEAEFADACCBEDBFBBFAEBFBCBECCAFBBFFEEEBFBCDACBABCCCAEDCEDADCAFADBABFCCAAABFEEBACFFABCFBFABDFABFEFADAEFDCADCDBFCABCAAFDACFEAFCECFBEDAFBFFBFEAFBACDDEFEEBDEBEDDEBBBACCADBFDCEFABDCBFCFECDFDDFAADEDCCEDCEACDEFEAFEEBAFBDEDBADFDEBCBBCEAEFDEFDDAFCDBEBABBABEEAEEDBEFEBBCEEFBAABFBCFEABDFAFEAADDFCEEBECDDBCFACBECECDEFDEBEECEBEFEDADBDABAEEFFEAFEEBDACDCAEBDAEBACFBABFBEADBDBAADAACADCEBCDCEADEEDDAEDFCFBCDBFAEDAFAACEABFADDEEEEDCFCBABAADEAFEBDEAAEFAAFECDEBEDABDBAFBECFCCEFFFFEADFFFDDCAFCBBFBBBEFBACEEDEACEFFEFCEADAACAAFBBAEACCFBCFABBFDDFCEFCDACACFBEBEADEECFEADCBDFDCFCBBDBAFAFCBFAFEFDAFEDBAEDEDABDEECEBECDFBACEDAFEFABFEDEADCAEAFDECCDEEFCECDBFBCDCCCACADFBDEEEFCBABCAFAAACBECDEACEDBBAFBDFDDCEAAADABDCBDADECCCEFFBBDBDFFAFFBEAAABBAFBFFAEAAFEDFDABDBCFFACECCEAFEFCCCBECEBECEDDFCCFECDFCDDAECDCCDDCCFEAABCECFFCBAFBDBABAEDAEFCAFADEBFECECBEEABFECBCDFFCCFECEECAFDFEFCFFBCAEFADADFEFEEFECCFAECCBCADBEACFCCAFFFFCBABDEBBDFDFCBCDCFDBCEBACEEDAEEFCDCFEFEEBBBEBADEEEBBFCEFEACDFEFFAFECBCCDACCDADABBEDBEFCDCADDDCECCEEBADBABCAABBEDBABABDCEFEEADBAFBCDCBBABEBFADEBBACFCBFBCFBBACFEABEDEBCCAEFDAFFAAADCAFDEBEDABCCDCDADFDFFFBBAACFFEDCCFBDBABCBFFDDDAFBCFFBFACECDDCBCDADAEFCEAEBBDABCBDCFCFAEDEBAFFEAFEBBFECDDEDEDCBAFFDFABBDEFEDDAFBFDDEEBADBFFFEDACDAEAAFADDBDCCDBEEABBBEBBCAFAABFFEAABEACFFFAAFEBCAAEEBEFDDBECECEBCEFCABBDBBABECAAFFDBCDCFDAAFCABBEAAFCDAAEECEBCADCDAFDECDBDDBFCBEDEBDDBFFAEDFBAAAADDECBDDBBECFFFFCEACEEEACDBDCDFFBFBEFFABBAFBCACDBFDCBFAAFCBFCAAACBBEFAACAAACFDACADDDCACACBDBAABDEFCCCFAFAFAACDDBDFBFECFEADEEECABAFDECADDDFADBEDBBAFEBFBEBAEAACDECCACACEDCEFECEFFFBBBDFBCBDBCCDDFCABEDFDCEECAAFFBEEDCEBDCEEEBFAEBBFFCFFCDFDDBBBAECBFEBDEEDCEFDDFBDBCDBBEEFFDEFFCBBFDBCFECBECEBDADEEDDBBEADCFCCAABABACBBCAACFEABBFAADDFEFDAFDDFDBBCCBFCBDEEEBAFDEDDCAEBDCDABCACFFDDCEECDEDCCBCAEFCECFDCDCBCDEEACAEAACBADDCFACABFFBCCEACFEFFACDCFDFCDDCBFEEFCFCDFEDACAAFADDAAAAFCBBBABFAACCEEFABAECCECFFFADEBEEDEECCABAAFCECEDFFBACCCEDCCEACAEEBBCBFACBCAEABCEFEABCEBAFBBECEEABDDFEBBFCDDBCBBCEFFEADCBCDCDFBCBABEBAEFEDFEADBEBFFFBAEEADFDDDDFCEECEBDEFFDCBBCDFAFDDFEADEBADACBDAFDDDCCCEDAAFECFFFFDCADEDDFAFBFDEBDBFABEEAFDBFEEDFDECFCBFCDACDDDADECCFDEFADFFCECCDBEDCDCDFFEACDDABFEEDEBFDFADACEEFACEFCECEEAADFBBDEEAEEDDBEECFAFFFDDEBBADBADDFBEBAFDFEAFFCEEEFFACDDECCDFBBBAFFCCAAFEACEAABEDBBAAAEFEAEBFBFCBFFFFADDEEFAEAFFCAACCBDBBAEFACCCCEDDCBBACBEACCDFFBAEAABCFADFFDACCAEFAABCDDFBFCAEAEEDADEDFAFEBDEFAFBDAECAFCCAEBEEFEABEFBEFAFFFFCAACBBDDBDBCCBFDFCDDDAFDCCEBCFECDBFCDEEAFEEACFFCCFFCCAFDCFBEACCEEEECDFFBBAACAEDCEDDCEADEFFFADCBDAEBCFDAFBABCACCCEBEFFEDCBBCDBECCEADAEDEFBFEFEDFDAECEBBFAEBFDBCFECBCBCEFCBCFCDFCDEBBDCFDAEEFCBDCDEACEABCEACBBBBDCBFDCBACABCADBDEEADEFBFADDAAFCFEADCFADBFFAEFAEEAAADBDEEEBFADBACEEEEDDEABAADFCADDFCDFECEFBDFDFDBAAEDBEAFFDCADEDFDDFDEEBACFEFCDCDAFABBABDFFECCDCDCABBBFFBACEEAFBFFFCCCCEBFCDFCBABDBBBDFFFFBECACBEAABADDFEBACDBAFDDCBBBFDACFDECEEDCBAACBEBBFEABEBCCACDEFDCABECFEFACFDEBEFCADDBDABEFFEBBFFCCCDFEDDAECEFDCEAEEBCCCABFBAABAFFBFADAAEEACEBFAADCEEEFDEAACECDDBEDBDDBBEABDEAADEBDBCEABFBEFADCDBECBFFAADFEEEAEDAEAECDCDAFAFBBBEBBBBBEECDDBDBACEACEDEAFDDCEBBEBFDECCFCDFDEDFFDBBDBDFBACADBCECDFBBFFBBDBECAEFADDBDBBFAAFCCCFFAAFEBFCEECBDFACBEDACEEFCEDEFBFCAABEEDCDAEBAEFACEDEEFCADCADEAFABDDBEDEBFEACEDCBCBAFFADAFCBDBBFFFCCFBEFCFEDCFDFFFBEDCDBEDAECCEACCCCEBCAEDDBABCCFBEBBDBCABFAFBAADBDBCEEFBFADBAEACEFBEACCAFADBBDEFFEDADABCCECADAABFDDFFDFDCBDAFFEAEFBBFEBBBDEDDCECAAEFFDCEFCFCCEABCAFAEFADFFBCFDECBABEDCEEEDABCDFDCCBEFBACBAABBADEBFCAEDCCBAFADBEBEFCCDAFBFFDCFFDAFFEABECDBFFBEEFFCEABEBBFFFDDDACCCBBCEABEEBCDDEFCACBDDAFBBFFCECADAABEAABEBDFDEDBBBAECDDAEBCBFFBEBADDDEDDAEFEADBECFDEAEBFEBCAFBFACCBDFDADEADCACEDBAEABFECFCFBFBEFCFCCCFFBAECFEDFBCCBABFDCFCFEFEDDAEEADFCEFDADABBCCCFEACBABDDEAEDBBAEBBEAADFBEDEACBDEFDAFECAFADDDBFCCEAFAEDBFDDDFEEABCDBBAAEBCEDAFBFBBFEACAFEAFDCBCCECAFDDAADDADCAEACBBABEDFBFFCCBACCAEEFFACADEFBDDEDFFDCEABABEFDFCBEDCAEDAAFCCABEACCBBEBDCEEDEACCDCEACCFCDFBAEDADBFCFBBCFDBBEFCDECDDFAEAEBBFBADDFDABBBECEAAFEBBDDDDAACEECEBFBEDEBFDFFEDDACFBABDEFACFFBADCBFDCFCACBFEAECDDFECDAFCACADAACEFBDFDFEFBFDADDADBBCACEEDCAEAFFBCCAFEDEEFFFFEAAEDCAADCDECCCCFCFDABAFDDCACAECCCDBEEACFEBCACBFFABDEBEEAEDBBCFDEBDBACAAAADDDECBBBEDFFDDCCBAECDDBEEECBBCCFFDEBDDCEEEEEEBDFCDBDBFBAADAFACBBBCBAEAEFBFACAEAFFAEEFABDEBFACBBCDABABBECDACABABAEABFCAAADEBBACFBCEBBDCAEEABAACBBCCACFDAFBDCCCEDDDEEECFBDCAECCACFACDFCFBBDBDBCDCBDEEEEEACDDBBDDFACCDCCDABCFDCECFFCEEEECCFFFDCAEACFCDEBAEFACFBAEDAFCEDCFDEDCCDFBFCBBBEEEBDBBBDABDBCCDEBBCCCAFCFFCDCCCBEACBEBABFCFEEFDFCECBBFCDADECBFAFAFCABCBECDAAFEEFDDECBBDBFBABFEDAADCBBAEEACEACABFACEECAAFEEBABBDABFAEBCDEDCACCDCBAFFEDCEAEDBEBBEEDBFCDDEFAECFEDFFBDFDDCECAFCACBDEEBFFFFABEABEACEACFFEBEDFBBDBEABFDDDEDEDFABEEEDBECBBCDAFBDADEFDCBBBBBAAABEFDEDAECDCCACAECFBAEBDCEBEAAECDBDCDEEDCFECADCABDCCBCECDCDEBACCBFFBFBBECFEFCEFFDEFFEDFEBBAABFCCFDEBBADAFFAECEDAAEEBEACEDDECFDEAFBFACAEAAAABCDCBABFABDCBFAFBBFAADCAEEECFBFECBAEADEAAFBEDECBFEECCCEEBFAFDFBFCCEBFEFAFECDCDABEAFEADBCEFBEDAEAFBBBBFAFCFAECCBBECBCFEAECEACACCADEFFDCFEDADDBDEEEDDCBCECBEAFBCCFDCBBEFFDEACDCBCFCEFABEADACEEBAEECCDDFAFFEACAEEADEAFAFDAADCABDFDBCAEEADBFBADEFEAEEFDDFAFEAEBECFDCEEBBACAAFDEEFCCEECEDADEABCAAADEACCFADCEFBCEDEEEFEEDDEDBFABBBCCBCCBBECAFFEBEAFEEBEDBAFADCCDFBBEEECFABCFEBACBFDDFCBFCADBDECBEABACEDFBDDABFDFDAABCECDCCBCACEFEEAEAFDEACBCACEDCAFCEAEECFBAEDCCBACBFACBEADADFCFEBCBDBBAAFFDFBCEECCDECFDBAFABCDAADABECCDFEBDEBBCFCCDEFECADDEFFBDAEEDCFABCACFFBFFDCDDBCDADDCBBBDADBCCDCFDABEEDACEFEBEADBBDCAFDEFFCFACCFAFAEAECDDFEBFFAECCACFBCFDDDDFCCDBFAEAFBCDBFFAFADCBCAEFACFEABACFFACFCCADDCCCEEDCEFECEEEEFECAFFDABAAEFBFFECEDEFFEFEFCBBCBEBAEFCCEAAABBADDFDAABFFAAEBCBBDADFBCECBABFFECEEFDECBCECEBADBADEFBDCCDDAECFECFFACEFDAEBFEFEECAEBFDFABEDADAABCECCAFDEDFBAEFFCDDAFFEDBEEAEFFDFDFEEBCCDDAAADAFFFADABCFFCCCEDAEDEAEFFCEBDFBBCBDFBFAAEEDEABBCFADEFBAAFBBBDBDBCFAEBCAAFCBEDEFFEEEBAAADBABCCEBFACEEFFBFBAFBFBCDBFDACDFABBCFCFDABCBCEAAEDCEBABCFBDADABAFDADAEFDEBAFBABFBBFEBACEADFEACAACAAFACDEDFCAABBFDCDADECDDEADDAFDACABDACDACEFBCBFDADAACDFDFCCDFBBDFEFFCDACFBAAAFCADBADCECDFFABCFACEBDADFABCDCDFFABACCBCEFCAEFFDEDCDFAEDFBCBDFAFFCDDCCDEABFAFFDDAAAEAFABAEFCABEFFAFFEBBEEDEECEDBFDAEBFCFBAEDEFDAADFFDCBEBFBBFFAFFBECBDCCFCDCCFCBBFFBFADACABDCFCDDAECCBBAEEEEEADBFADFACFEEBDFDFCBCDCDBBFECFCFAEBDCDAFEFBFDBCDBDFCADFEBCBDCFDDFFFFAACDACFEBECAAACCDFDCDAEEEFCCCBCCFECEACACEEBDEBFFEFEFECBFAECDAEDDACEDCBBBFDDBDFDEBFEDCFBFEAFAEFADBBCBAFCCBFDDFAADFFEDDBDACBCFEAFDDACCDFFCCFFDEEDBDEFCABCAFECDBCEBCADCBEFCEBABCFBECCCEBCDCBABFBEDCABEFECCEBFBECBCAABFADDEEACCEAADDBCEAFEDABCDDFBACFEDFCEAFFDCAAEDABEFEAAECECBDACEFCBBBFDACDCCDECCCFABABFDCBFBECCACDAAFDFDDEDEFCABABAACABECDCFAEDFFDBDECCCCBFDEBFECEFDFCCEEDECEEBDEDCBCABACBBEAFCDADFAFFCADDDDDDDEEFEBAAFEEFEDADABFACABDACCDBEBEDDFDFBECEFECDAECBAEECFFACEFAFFDCCBEDEBABEEADCBBCBCFDCCADBAADFCDEBFEFFCBDACECDFEABBBDEBADAEBFEDBABEFCDCBFCAFCCAEAEDDDCBEBDCDAEFCBBAEFEEFDAACEACAACBEEFAFDEBDCCBAAEFFCAEFDFBAFFDBCAEAFCCDADEAADCAADAFCDAADAFFCAEFBDDEADAEDEBACDAEDFDFEDCEDFBBEAFCDDEFDCEDFCFCDFEEECDCCBBEBBBFFBAEBFEEBDDFDEDFBFCABFDFFCBDEBADEFAFADCDBAABAEEFFBDEDBCBEDFBBBEAEBEDEDAADDBBFFDFFDDEBFBBDBFFBFCDADFBAACCDABBCADBEAAAECEEDAEBFBDADEBAADFCDBAEBBFCCCFDBACAAAEFCCDACFFFFDAADBEAABACABEBCAEEAAACFCAFDBFDBFCDCEDBBFEDECEBCBACEFFAEEDFECAABDBFEABAEDCBDFBFBAFCEADEEDDDEFEDEEFFBCAEDDDDDFADABABAFFEECADEBFCBEDBDCEDDDECDBEAFCEBCBEEBBEFBDBEDEEDCABDEDBEBAAEFDFFEBADABCCABBABCBDFFCFACCCEEDACEBFAAAFBEAFFEBECACFBAFCDAFAFFADECFACAEFEEDDBBFEBBCFBFACBCDEDBABECBEBFEEBBBBCEFEACDFECAFCEADEFABEBEFEEDDEDFDFDEEDFDFCFEFBEECDCDFFDCFBFCFFEACCFCDEBAFCBAEDFDECEBEEAFEECFDBBBEAABDEDDACDACCBCCAEFAFFBCDDEAEABBEECBCBAADFFBBCCFFCFBDADEBACEECECFBEDBEBBDBCEBDCFDABBDBDECBDCADECDBAFCADBDDAEBEADEEFEAABABACCADEEBBBAAFEBBCADCBEAFACDDFAADBAFDBCFFAACFFDCFCCFCACDFDCFCEBCDBAEEACEFEFFBEBBFFFCFAEDFDEFCDDAFCFEEBEEAFDCBCAACBFECBFBCDDBCFACDDEBE", 3371); //4
        System.out.println("Result: " + result);

//        result = instance.characterReplacement("ABAB", 2); //4
//        System.out.println("Result: " + result);


    }


}
