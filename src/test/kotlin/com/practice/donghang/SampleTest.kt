package com.practice.donghang
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SampleTest : FunSpec({
    test("샘플 테스트 진행") {
        1 + 2 shouldBe 3
    }
})
