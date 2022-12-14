package com.springboottest.demo;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.springboottest.demo.entity.Topic_Info.user_num;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringboottestApplicationTests {

    public String pre_process(String a) {
        List<Integer> invalid_quote_index = new ArrayList<>();
        boolean help = false;
        StringBuilder sb = new StringBuilder(a);
        for (int i = 0; i < a.length() - 10; i++) {
            if (a.substring(i, i + 9).equals("\"title\":\"")) {
                help = true;
                i += 8;
                continue;
            }

            if (help) {
                if (a.charAt(i) == '\"') {
                    if (a.substring(i, i + 2).equals("\"}")) {
                        help = false;
                        i += 1;
                    } else {
                        invalid_quote_index.add(i);
                    }
                }
            }
        }
        for (Integer invalidQuoteIndex : invalid_quote_index) {
            sb.replace(invalidQuoteIndex, invalidQuoteIndex + 1, " ");
        }
        return sb.toString();
    }

    @Test
    void contextLoads() {
        String a = "{\"items\":[{\"tags\":[\"python\"],\"owner\":{\"account_id\":25349115,\"reputation\":1,\"user_id\":19166249,\"user_type\":\"registered\",\"profile_image\":\"https://i.stack.imgur.com/Zb6Gv.jpg?s=256&g=1\",\"display_name\":\"Quarksta\",\"link\":\"https://stackoverflow.com/users/19166249/quarksta\"},\"is_answered\":true,\"view_count\":21,\"closed_date\":1653376612,\"answer_count\":2,\"score\":0,\"last_activity_date\":1653376622,\"creation_date\":1653376343,\"question_id\":72358619,\"link\":\"https://stackoverflow.com/questions/72358619/split-long-dictionary-value-over-two-lines\",\"closed_reason\":\"Duplicate\",\"title\":\"Split long dictionary value over two lines\"},{\"tags\":[\"python\",\"numpy\",\"paillier\"],\"owner\":{\"account_id\":8884417,\"reputation\":73,\"user_id\":6633161,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/50bfb338753d4f84bfd5e26fbaf02fd7?s=256&d=identicon&r=PG&f=1\",\"display_name\":\"meirgold\",\"link\":\"https://stackoverflow.com/users/6633161/meirgold\"},\"is_answered\":false,\"view_count\":6,\"answer_count\":0,\"score\":0,\"last_activity_date\":1653376515,\"creation_date\":1653376515,\"question_id\":72358654,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72358654/encrypting-a-numpy-array-using-paillier\",\"title\":\"encrypting a numpy array using paillier\"},{\"tags\":[\"python\",\"python-3.x\",\"multithreading\",\"python-multithreading\",\"interactive-brokers\"],\"owner\":{\"account_id\":2015220,\"reputation\":1235,\"user_id\":1802693,\"user_type\":\"registered\",\"accept_rate\":57,\"profile_image\":\"https://i.stack.imgur.com/74kUV.jpg?s=256&g=1\",\"display_name\":\"elaspog\",\"link\":\"https://stackoverflow.com/users/1802693/elaspog\"},\"is_answered\":false,\"view_count\":15,\"answer_count\":1,\"score\":1,\"last_activity_date\":1653376512,\"creation_date\":1653374894,\"question_id\":72358322,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72358322/how-to-kill-a-thread-in-python-with-blocking-command\",\"title\":\"How to kill a thread in python with blocking command?\"},{\"tags\":[\"python\",\"arrays\",\"machine-learning\"],\"owner\":{\"account_id\":24085617,\"reputation\":1,\"user_id\":18059670,\"user_type\":\"registered\",\"profile_image\":\"https://lh3.googleusercontent.com/a/AATXAJwmA3rcJQpNAET992OzOCZBzpJA7Ul3iiepB8y5=k-s256\",\"display_name\":\"Zurichko_101101\",\"link\":\"https://stackoverflow.com/users/18059670/zurichko-101101\"},\"is_answered\":false,\"view_count\":9,\"answer_count\":0,\"score\":-1,\"last_activity_date\":1653376389,\"creation_date\":1653376389,\"question_id\":72358635,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72358635/how-do-i-convert-values-of-data-frame-to-string-type-and-how-do-i-use-train-test\",\"title\":\"How do I convert values of data frame to string type and how do I use train_test_split to generate the two arrays with same dimensions?\"},{\"tags\":[\"python\",\"sqlalchemy\"],\"owner\":{\"account_id\":18202800,\"reputation\":61,\"user_id\":13246657,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/d8f45dc8de91352f41ca49b8693cace9?s=256&d=identicon&r=PG&f=1\",\"display_name\":\"Neykuratick\",\"link\":\"https://stackoverflow.com/users/13246657/neykuratick\"},\"is_answered\":false,\"view_count\":32,\"answer_count\":1,\"score\":1,\"last_activity_date\":1653376389,\"creation_date\":1652543833,\"question_id\":72241883,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72241883/sqlalchemy-select-from-joined-table\",\"title\":\"sqlalchemy: select from joined table\"},{\"tags\":[\"python\",\"jupyter-notebook\",\"ipywidgets\"],\"owner\":{\"account_id\":177544,\"reputation\":1,\"user_id\":5218058,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/2adc95f396a5b0a7e3f0aff3ca3c4cfe?s=256&d=identicon&r=PG&f=1\",\"display_name\":\"Mukesh C\",\"link\":\"https://stackoverflow.com/users/5218058/mukesh-c\"},\"is_answered\":false,\"view_count\":9,\"answer_count\":1,\"score\":0,\"last_activity_date\":1653376351,\"creation_date\":1653368985,\"question_id\":72357455,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72357455/ipywidgets-jslink-non-direct-mappings\",\"title\":\"ipywidgets jslink - non direct mappings\"},{\"tags\":[\"python\",\"python-3.x\",\"build\",\"bazel\",\"macos-monterey\"],\"owner\":{\"account_id\":8669169,\"reputation\":67,\"user_id\":6488612,\"user_type\":\"registered\",\"profile_image\":\"https://i.stack.imgur.com/UH2qc.jpg?s=256&g=1\",\"display_name\":\"Abhishek Garg\",\"link\":\"https://stackoverflow.com/users/6488612/abhishek-garg\"},\"is_answered\":true,\"view_count\":638,\"answer_count\":2,\"score\":2,\"last_activity_date\":1653376308,\"creation_date\":1649320604,\"last_edit_date\":1649322105,\"question_id\":71778867,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/71778867/bazel-build-fails-with-msg-env-python-no-such-file-or-directory-macos-monte\",\"title\":\"Bazel build fails with msg \"env: python: No such file or directory\" (macOS Monterey)\"},{\"tags\":[\"python\",\"pyqt\"],\"owner\":{\"account_id\":19921442,\"reputation\":63,\"user_id\":14597188,\"user_type\":\"registered\",\"profile_image\":\"https://i.stack.imgur.com/Xv0HD.jpg?s=256&g=1\",\"display_name\":\"TheCrazySwede\",\"link\":\"https://stackoverflow.com/users/14597188/thecrazyswede\"},\"is_answered\":false,\"view_count\":4,\"answer_count\":0,\"score\":0,\"last_activity_date\":1653376293,\"creation_date\":1653376293,\"question_id\":72358607,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72358607/pyqt6-running-downloads-with-a-progress-bar\",\"title\":\"PyQt6 running downloads with a progress bar\"},{\"tags\":[\"python\",\"python-3.x\",\"django\",\"opencv\",\"python-imaging-library\"],\"owner\":{\"account_id\":25373080,\"reputation\":21,\"user_id\":19186562,\"user_type\":\"registered\",\"profile_image\":\"https://lh3.googleusercontent.com/a/AATXAJwNyta2R8uiOpjOiVxseKm2wkLj6hj_IIbFIbE6=k-s256\",\"display_name\":\"Pythonista \",\"link\":\"https://stackoverflow.com/users/19186562/pythonista\"},\"is_answered\":false,\"view_count\":17,\"answer_count\":1,\"score\":2,\"last_activity_date\":1653376272,\"creation_date\":1653375731,\"last_edit_date\":1653376024,\"question_id\":72358488,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72358488/django-save-only-resized-image-not-the-original\",\"title\":\"Django, save only resized image, not the original\"},{\"tags\":[\"python\",\"opencv\",\"image-processing\"],\"owner\":{\"account_id\":16709647,\"reputation\":75,\"user_id\":12077176,\"user_type\":\"registered\",\"profile_image\":\"https://lh5.googleusercontent.com/-y-zQVjn78Eo/AAAAAAAAAAI/AAAAAAAAAAA/ACHi3rdtJXdndaF5vjXXZofq5Hd3bUS0kw/photo.jpg?sz=256\",\"display_name\":\"Tech Five\",\"link\":\"https://stackoverflow.com/users/12077176/tech-five\"},\"is_answered\":true,\"view_count\":3703,\"accepted_answer_id\":59754709,\"answer_count\":2,\"score\":2,\"last_activity_date\":1653376255,\"creation_date\":1579067186,\"last_edit_date\":1579269655,\"question_id\":59745730,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/59745730/get-white-text-on-black-background\",\"title\":\"Get white text on black background\"}],\"has_more\":true,\"quota_max\":300,\"quota_remaining\":179}";
        String b = "{\"items\":[{\"tags\":[\"c\",\"ubuntu\",\"ebpf\",\"xdp-pdf\",\"libbpf\"],\"owner\":{\"account_id\":19630220,\"reputation\":1,\"user_id\":17321123,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/5e277fd8be00a00a40dcf081837e8c2b?s=256&d=identicon&r=PG\",\"display_name\":\"Roy Carter\",\"link\":\"https://stackoverflow.com/users/17321123/roy-carter\"},\"is_answered\":false,\"view_count\":7,\"answer_count\":0,\"score\":0,\"last_activity_date\":1653381476,\"creation_date\":1653381476,\"question_id\":72359742,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72359742/ebpf-cannot-open-source-file-bpf-bpf-helpers-hc-c1696\",\"title\":\"EBPF - cannot open source file \"bpf/bpf_helpers.h\"C/C++(1696)\"},{\"tags\":[\"c\",\"csv\"],\"owner\":{\"account_id\":25314652,\"reputation\":1,\"user_id\":19136945,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/611217465f3402940cb42068cbd5a653?s=256&d=identicon&r=PG\",\"display_name\":\"syrianfox\",\"link\":\"https://stackoverflow.com/users/19136945/syrianfox\"},\"is_answered\":false,\"view_count\":7,\"answer_count\":0,\"score\":-1,\"last_activity_date\":1653381344,\"creation_date\":1653381344,\"question_id\":72359718,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72359718/reading-from-a-csv-file-in-c\",\"title\":\"reading from a CSV file in C\"},{\"tags\":[\"c\",\"sorting\",\"mergesort\"],\"owner\":{\"account_id\":25240741,\"reputation\":37,\"user_id\":19074648,\"user_type\":\"registered\",\"profile_image\":\"https://lh3.googleusercontent.com/a-/AOh14GjyZdJgL7Yy3f-yfA0cHHVn_tmSbYh1yj_6XoV8VQ=k-s256\",\"display_name\":\"12iq\",\"link\":\"https://stackoverflow.com/users/19074648/12iq\"},\"is_answered\":false,\"view_count\":23,\"answer_count\":1,\"score\":1,\"last_activity_date\":1653381182,\"creation_date\":1653379335,\"last_edit_date\":1653380401,\"question_id\":72359269,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72359269/merge-sorting-does-not-reach-the-last-element\",\"title\":\"merge sorting does not reach the last element\"},{\"tags\":[\"c\",\"opencl\",\"pyramid\"],\"owner\":{\"account_id\":20637080,\"reputation\":11,\"user_id\":15150514,\"user_type\":\"registered\",\"profile_image\":\"https://lh4.googleusercontent.com/-8uyWG5A1kmA/AAAAAAAAAAI/AAAAAAAAAAA/AMZuucmWOs6Ja8vrWz5IwaQd1zbwe4NpxA/s96-c/photo.jpg?sz=256\",\"display_name\":\"Ethan Kim\",\"link\":\"https://stackoverflow.com/users/15150514/ethan-kim\"},\"is_answered\":false,\"view_count\":12,\"answer_count\":0,\"score\":0,\"last_activity_date\":1653380910,\"creation_date\":1653370737,\"last_edit_date\":1653380910,\"question_id\":72357676,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72357676/its-like-opencl-kernel-instance-ends-abruptly\",\"title\":\"It's like OpenCL kernel instance ends abruptly\"},{\"tags\":[\"c\",\"parent-child\"],\"owner\":{\"account_id\":16504918,\"reputation\":1,\"user_id\":17137987,\"user_type\":\"registered\",\"profile_image\":\"https://i.stack.imgur.com/k3lxB.png?s=256&g=1\",\"display_name\":\"Hames Rodrigues\",\"link\":\"https://stackoverflow.com/users/17137987/hames-rodrigues\"},\"is_answered\":false,\"view_count\":22,\"answer_count\":0,\"score\":0,\"last_activity_date\":1653380217,\"creation_date\":1653379326,\"last_edit_date\":1653380217,\"question_id\":72359267,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72359267/c-programming-write-and-addition\",\"title\":\"C Programming Write and Addition\"},{\"tags\":[\"c\"],\"owner\":{\"account_id\":25372060,\"reputation\":1,\"user_id\":19185704,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/519c82cd482fdb0268cf76b1c1b49b7b?s=256&d=identicon&r=PG\",\"display_name\":\"RN19\",\"link\":\"https://stackoverflow.com/users/19185704/rn19\"},\"is_answered\":false,\"view_count\":24,\"closed_date\":1653366264,\"answer_count\":1,\"score\":-4,\"last_activity_date\":1653379877,\"creation_date\":1653365211,\"last_edit_date\":1653379877,\"question_id\":72357098,\"link\":\"https://stackoverflow.com/questions/72357098/how-do-i-solve-the-following-of-c\",\"closed_reason\":\"Needs more focus\",\"title\":\"How do I solve the following of C\"},{\"tags\":[\"c\",\"file\",\"text-files\"],\"owner\":{\"account_id\":175815,\"reputation\":6352,\"user_id\":406110,\"user_type\":\"registered\",\"accept_rate\":55,\"profile_image\":\"https://www.gravatar.com/avatar/a57a0ccb5037ca7e12dd29206eee0d00?s=256&d=identicon&r=PG\",\"display_name\":\"richardaum\",\"link\":\"https://stackoverflow.com/users/406110/richardaum\"},\"is_answered\":true,\"view_count\":726700,\"protected_date\":1384923245,\"accepted_answer_id\":3463793,\"answer_count\":9,\"score\":120,\"last_activity_date\":1653379763,\"creation_date\":1281566434,\"last_edit_date\":1281568051,\"question_id\":3463426,\"content_license\":\"CC BY-SA 2.5\",\"link\":\"https://stackoverflow.com/questions/3463426/in-c-how-should-i-read-a-text-file-and-print-all-strings\",\"title\":\"In C, how should I read a text file and print all strings\"},{\"tags\":[\"c\",\"math\",\"arduino-ide\"],\"owner\":{\"account_id\":24934469,\"reputation\":1,\"user_id\":19186613,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/6d19822d1086cc7f66471ef6819f13d0?s=256&d=identicon&r=PG\",\"display_name\":\"NoobEE\",\"link\":\"https://stackoverflow.com/users/19186613/noobee\"},\"is_answered\":false,\"view_count\":21,\"answer_count\":2,\"score\":-1,\"last_activity_date\":1653379626,\"creation_date\":1653375861,\"last_edit_date\":1653377970,\"question_id\":72358524,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72358524/calculating-displacement-based-on-the-compass-direction\",\"title\":\"Calculating Displacement based on the compass direction\"},{\"tags\":[\"c\"],\"owner\":{\"account_id\":16093210,\"reputation\":89,\"user_id\":11616106,\"user_type\":\"registered\",\"profile_image\":\"https://lh6.googleusercontent.com/-nN-orBkJ9X4/AAAAAAAAAAI/AAAAAAAAAEc/WGtvmSJ36Ww/photo.jpg?sz=256\",\"display_name\":\"hobik\",\"link\":\"https://stackoverflow.com/users/11616106/hobik\"},\"is_answered\":true,\"view_count\":307,\"accepted_answer_id\":68190892,\"answer_count\":1,\"score\":0,\"last_activity_date\":1653379502,\"creation_date\":1625037272,\"last_edit_date\":1653379502,\"question_id\":68190044,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/68190044/converting-uint64-t-to-double-value\",\"title\":\"Converting uint64_t to Double Value\"},{\"tags\":[\"python\",\"c++\",\"c\",\"audio\",\"librosa\"],\"owner\":{\"account_id\":1653828,\"reputation\":1997,\"user_id\":1523874,\"user_type\":\"registered\",\"accept_rate\":9,\"profile_image\":\"https://i.stack.imgur.com/K5KA4.jpg?s=256&g=1\",\"display_name\":\"Celik\",\"link\":\"https://stackoverflow.com/users/1523874/celik\"},\"is_answered\":false,\"view_count\":13,\"closed_date\":1653378297,\"answer_count\":1,\"score\":-1,\"last_activity_date\":1653378575,\"creation_date\":1653377809,\"last_edit_date\":1653378575,\"question_id\":72358907,\"link\":\"https://stackoverflow.com/questions/72358907/how-can-i-use-librosa-feature-extraction-methods-in-c-c-or-java\",\"closed_reason\":\"Not suitable for this site\",\"title\":\"How can I use librosa feature extraction methods in C/C++ or JAVA?\"}],\"has_more\":true,\"quota_max\":300,\"quota_remaining\":144}";
        String c = "{\"items\":[{\"tags\":[\"java\",\"spring\",\"spring-boot\"],\"owner\":{\"account_id\":24089127,\"reputation\":11,\"user_id\":18062652,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/f1f1cf6d1f37becd77b64efb1fe19ec8?s=256&d=identicon&r=PG\",\"display_name\":\"shield\",\"link\":\"https://stackoverflow.com/users/18062652/shield\"},\"is_answered\":false,\"view_count\":18,\"answer_count\":1,\"score\":0,\"last_activity_date\":1653379129,\"creation_date\":1653371212,\"last_edit_date\":1653371331,\"question_id\":72357737,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72357737/i-am-getting-this-error-failed-to-start-bean-documentationpluginsbootstrapper\",\"title\":\"I am getting this error \"Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException\"\"},{\"tags\":[\"java\",\"tomcat\",\"netbeans\"],\"owner\":{\"account_id\":22783471,\"reputation\":1,\"user_id\":16939023,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/98ceaa5d234da7d89547174d946f3c6f?s=256&d=identicon&r=PG&f=1\",\"display_name\":\"TaTrungLink\",\"link\":\"https://stackoverflow.com/users/16939023/tatrunglink\"},\"is_answered\":false,\"view_count\":2,\"answer_count\":0,\"score\":0,\"last_activity_date\":1653379111,\"creation_date\":1653379111,\"question_id\":72359216,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72359216/netbeans-stucks-on-creating-a-new-java-servlet\",\"title\":\"Netbeans stucks on creating a new java servlet\"},{\"tags\":[\"java\",\"locale\"],\"owner\":{\"account_id\":24287116,\"reputation\":159,\"user_id\":18232723,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/aa15edbf48e7c7679397ca57021e48c1?s=256&d=identicon&r=PG\",\"display_name\":\"kylie.zoltan\",\"link\":\"https://stackoverflow.com/users/18232723/kylie-zoltan\"},\"is_answered\":true,\"view_count\":277,\"accepted_answer_id\":72349890,\"answer_count\":4,\"score\":9,\"last_activity_date\":1653379106,\"creation_date\":1653312332,\"last_edit_date\":1653317376,\"question_id\":72349380,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72349380/how-can-i-create-a-locale-with-a-specific-script-code\",\"title\":\"How can I create a Locale with a specific script code?\"},{\"tags\":[\"java\",\"spring\",\"spring-webflux\",\"netty\",\"servletcontextlistener\"],\"owner\":{\"account_id\":471451,\"reputation\":67,\"user_id\":10471045,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/d6a4702b03c406a579e66747363ae9b3?s=256&d=identicon&r=PG\",\"display_name\":\"cool_ravi\",\"link\":\"https://stackoverflow.com/users/10471045/cool-ravi\"},\"is_answered\":false,\"view_count\":5,\"answer_count\":0,\"score\":0,\"last_activity_date\":1653378969,\"creation_date\":1653377823,\"last_edit_date\":1653378969,\"question_id\":72358910,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72358910/alternative-for-servletcontextlistener-in-webflux\",\"title\":\"Alternative for ServletContextListener in webflux\"},{\"tags\":[\"java\",\"arrays\"],\"owner\":{\"account_id\":10782332,\"reputation\":13,\"user_id\":7932474,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/b3d784a8d9466fbf0905c0474dbd2aec?s=256&d=identicon&r=PG&f=1\",\"display_name\":\"Guru\",\"link\":\"https://stackoverflow.com/users/7932474/guru\"},\"is_answered\":false,\"view_count\":6,\"answer_count\":0,\"score\":0,\"last_activity_date\":1653378923,\"creation_date\":1653378923,\"question_id\":72359166,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72359166/find-the-sum-of-custom-number-of-elements-in-an-array-of-integers\",\"title\":\"Find the sum of custom number of elements in an array of Integers\"},{\"tags\":[\"java\",\"arrays\",\"for-loop\",\"if-statement\"],\"owner\":{\"account_id\":20747331,\"reputation\":33,\"user_id\":15235665,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/2fcefbc999df1b84a4ef2795246eb924?s=256&d=identicon&r=PG&f=1\",\"display_name\":\"John Ng\",\"link\":\"https://stackoverflow.com/users/15235665/john-ng\"},\"is_answered\":true,\"view_count\":43,\"answer_count\":3,\"score\":2,\"last_activity_date\":1653378734,\"creation_date\":1653376373,\"question_id\":72358626,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72358626/remove-last-comma-in-for-loop-using-array\",\"title\":\"Remove last comma in for loop using array\"},{\"tags\":[\"java\",\"io\",\"serial-port\",\"text-files\"],\"owner\":{\"account_id\":24925171,\"reputation\":11,\"user_id\":18793030,\"user_type\":\"registered\",\"profile_image\":\"https://lh3.googleusercontent.com/a-/AOh14GibXEUkQ9xH8gvKytUAL6CeWgos4qjh-cHn0auq=k-s256\",\"display_name\":\"Jameel Ahmed\",\"link\":\"https://stackoverflow.com/users/18793030/jameel-ahmed\"},\"is_answered\":false,\"view_count\":12,\"answer_count\":0,\"score\":0,\"last_activity_date\":1653378730,\"creation_date\":1653378429,\"last_edit_date\":1653378730,\"question_id\":72359053,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72359053/reading-data-from-serial-port-and-save-to-text-file-in-java\",\"title\":\"Reading data from serial port and save to text file in java\"},{\"tags\":[\"java\",\"mysql\",\"netbeans-13\"],\"owner\":{\"account_id\":14139897,\"reputation\":1,\"user_id\":18632292,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/c0619c6522587f3de40f02e67263c1f2?s=256&d=identicon&r=PG&f=1\",\"display_name\":\"Akki\",\"link\":\"https://stackoverflow.com/users/18632292/akki\"},\"is_answered\":false,\"view_count\":12,\"answer_count\":1,\"score\":0,\"last_activity_date\":1653378714,\"creation_date\":1653377216,\"last_edit_date\":1653378707,\"question_id\":72358794,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72358794/java-lang-classnotfoundexception-in-netbeans-13-with-mysql\",\"title\":\"java.lang.ClassNotFoundException in netbeans 13 with mysql\"},{\"tags\":[\"java\",\"groovy\"],\"owner\":{\"account_id\":954101,\"reputation\":63,\"user_id\":979705,\"user_type\":\"registered\",\"accept_rate\":57,\"profile_image\":\"https://www.gravatar.com/avatar/7f27bc6367ffabd263cf7648e2bc24d4?s=256&d=identicon&r=PG\",\"display_name\":\"N.D.H.Vu\",\"link\":\"https://stackoverflow.com/users/979705/n-d-h-vu\"},\"is_answered\":false,\"view_count\":5,\"answer_count\":0,\"score\":0,\"last_activity_date\":1653378651,\"creation_date\":1653378651,\"question_id\":72359108,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72359108/in-groovy-how-to-properly-get-the-file-from-httpservletrequest\",\"title\":\"In Groovy, how to properly get the file from HttpServletRequest\"},{\"tags\":[\"java\",\"jenkins\",\"netbeans\",\"lombok\"],\"owner\":{\"account_id\":17436819,\"reputation\":65,\"user_id\":12639646,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/2e3bb0e7e22c4dcd6aac3301196e5434?s=256&d=identicon&r=PG&f=1\",\"display_name\":\"Daki\",\"link\":\"https://stackoverflow.com/users/12639646/daki\"},\"is_answered\":false,\"view_count\":34,\"answer_count\":1,\"score\":1,\"last_activity_date\":1653378498,\"creation_date\":1652701513,\"question_id\":72258692,\"content_license\":\"CC BY-SA 4.0\",\"link\":\"https://stackoverflow.com/questions/72258692/customizing-which-files-are-shown-in-netbeans-project-view-under-project-files\",\"title\":\"Customizing which files are shown in Netbeans' Project View under Project Files\"}],\"has_more\":true,\"quota_max\":300,\"quota_remaining\":154}";

        b = pre_process(b);
        JsonReader jsonReader = new JsonReader(new StringReader(b));
        jsonReader.setLenient(true);
        JsonObject jsonObject = new Gson().fromJson(jsonReader, JsonObject.class);
        System.out.println(jsonObject.get("has_more"));

    }

    @Test
    public void crawl() throws IOException {
        int date = 1217548800;
        int end = 1653436800;
        int id = 0;
        user_num temp = new user_num();
        temp.setId(id);
        temp.setNumber(0);
        String base1 = "https://api.stackexchange.com/2.3/users?page=1&pagesize=10&fromdate=";
        String base2 = "&todate=1653436800&order=asc&sort=creation&site=stackoverflow";
        int pre_num = 0;
        int number;
        int number2 = 0;
        List<user_num> list = new ArrayList<>();
        while (date < end) {
            Document doc;
            while (true) {
                try {
                    doc = Jsoup.connect(base1 + date + base2).ignoreContentType(true).get();
                    break;
                }catch (HttpStatusException e){
                    System.out.println("Failure with " + e.getStatusCode());
                }
            }
            JsonObject jo = JsonParser.parseString(doc.text()).getAsJsonObject();
            JsonArray ja = jo.get("items").getAsJsonArray();
            number = ja.get(0).getAsJsonObject().get("user_id").getAsInt();
            if (pre_num>number){
                list.get(list.size()-1).setNumber(number2);
            }
            number2 = ja.get(1).getAsJsonObject().get("user_id").getAsInt();
            temp = new user_num();
            temp.setId(++id);
            temp.setNumber(number);
            list.add(temp);
            pre_num = number;
            date += 2597000;
        }
        for (com.springboottest.demo.entity.Topic_Info.user_num user_num : list) {
            System.out.println(user_num.getNumber());
        }
    }

}