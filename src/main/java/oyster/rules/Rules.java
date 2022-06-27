package oyster.rules;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

@Builder
@RequiredArgsConstructor
public class Rules {

    @Getter
    @Singular
    private final List<Rule> rules;
}
