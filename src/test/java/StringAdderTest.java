import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import stringAdder.StringAdder;

public class StringAdderTest {
    @Test
    void 덧셈() {
        int result = StringAdder.add("1,2");

        Assertions.assertThat(result).isEqualTo(3);
        StringAdder.add("1:2");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void 빈값이나_null이_들어오는_테스트() {
        int result = StringAdder.add("");

        Assertions.assertThat(result).isEqualTo(0);
        result = StringAdder.add(null);
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_1개만_들어오는_경우() {
        int result = StringAdder.add("7");

        Assertions.assertThat(result).isEqualTo(7);
    }

    @Test
    void 숫자가_2개이상인_경우() {
        int result = StringAdder.add("1,2:3,4:5");

        Assertions.assertThat(result).isEqualTo(15);
    }

    @Test
    void 숫자가_음수인_경우() {
        Assertions.assertThatThrownBy(() -> StringAdder.add("1,-2:3,4:5"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("음수는 입력하실 수 없습니다.");
    }

    @Test
    void 숫자_이외의_값이_들어올_경우() {
        Assertions.assertThatThrownBy(() -> StringAdder.add("1,-A:3,4:5"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("숫자 이외의 값은 입력하실 수 없습니다.");
    }

    @Test
    void 커스텀구분자_사용했을_경우_최소조건() {
        int result = StringAdder.add("//;\n1;2;3");

        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀구분자만_들어올_경우_최소조건() {
        int result = StringAdder.add("//;\n");

        Assertions.assertThat(result).isEqualTo(0);
    }
}