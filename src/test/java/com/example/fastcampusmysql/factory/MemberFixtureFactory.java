package com.example.fastcampusmysql.factory;

import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.entity.Member;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.range.LongRangeRandomizer;
import org.jeasy.random.randomizers.text.StringRandomizer;
import org.jeasy.random.randomizers.time.LocalDateRandomizer;

import static org.jeasy.random.FieldPredicates.named;

public class MemberFixtureFactory {
    static public Member create(){
        var param = new EasyRandomParameters();
        return new EasyRandom(param).nextObject(Member.class);
    }
    static public Member create(Long seed){
        var param = new EasyRandomParameters().seed(seed);
        return new EasyRandom(param).nextObject(Member.class);
    }

    public static MemberDto createDto() {
        var parameter = new EasyRandomParameters()
                .stringLengthRange(1, 10)
                .randomize(Long.class, new LongRangeRandomizer(1L, 100L));
        return new MemberDto(
                new LongRangeRandomizer(1L, 100L).getRandomValue(),
                new StringRandomizer(10).getRandomValue(),
                new StringRandomizer(10).getRandomValue(),
                new LocalDateRandomizer().getRandomValue()
        );
    }
}
