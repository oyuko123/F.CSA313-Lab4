# Lab 4 — JUnit 5 Unit Testing

## Оюутны мэдээлэл

- Нэр: Т.Оюунжаргал
- Оюутны код: B232270149

## Орчны мэдээлэл

### Java

```text
openjdk version "17.0.20.1" 2026-08-18
OpenJDK Runtime Environment (build 17.0.20.1+1-1-26.04-Ubuntu)
OpenJDK 64-Bit Server VM (build 17.0.20.1+1-1-26.04-Ubuntu, mixed mode, sharing)
```

### Maven

```text
Apache Maven 3.9.9
Java version: 17.0.20.1
OS name: Linux, version: 6.18.33.2-microsoft-standard-WSL2
```

## Төслийн зорилго

Энэхүү лабораторийн ажлаар Maven-д суурилсан Java төсөл үүсгэж, JUnit 5 ашиглан GradeCalculator классын нэгжийн тестүүдийг хэрэгжүүлсэн. letterGrade() болон totalScore() методуудын зөв ажиллагааг ердийн болон хязгаарын утгуудаар шалгасан. Мөн буруу оролтын үед IllegalArgumentException үүсэж байгаа эсэхийг assertThrows ашиглан шалгасан.

## Тестүүд

Нийт 18 тестийн метод бичсэн: 16 `@Test` болон 2 `@ParameterizedTest`.

`results/mvn-test.txt` файлын дагуу нийт 26 тестийн тохиолдол ажилласан:

```text
Tests run: 26, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Тестийн 16 методын доторх parameterized тестүүдийн `@CsvSource`-ийн мөрүүд тусдаа тестийн тохиолдол болж тоологддог тул тестийн методын тоо болон `Tests run` тоо ялгаатай байна.

## Mutation Testing

Mutation testing хийхийн тулд GradeCalculator классын:

if (score >= 90) нөхцөлийг зориудаар if (score > 90) болгон өөрчилсөн.

Үүний дараа тестүүдийг ажиллуулахад:

```text
Tests run: 26, Failures: 2, Errors: 0, Skipped: 0
BUILD FAILURE
```

гэсэн үр дүн гарсан.

Mutation-ийг дараах хоёр тест илрүүлсэн:

1. `ninetyIsExactlyA`
2. `letterGradeBoundaries` — 90 → A тохиолдол

Алдааны үр дүн: expected: <A> but was: <B>

Ингэснээр 90 оноо нь A байх ёстой гэсэн хязгаарын нөхцөлийг тестүүд зөв шалгаж байгааг баталсан. Mutation testing-ийн дараа score > 90 нөхцөлийг буцаан score >= 90 болгон засварлаж, бүх тестийг дахин ажиллуулахад бүх тест амжилттай болсон.

## Хамгийн сонирхолтой алдаа

Хамгийн сонирхолтой нь 90 онооны хязгаарын нөхцөл байсан. >= 90 нөхцөлийг > 90 болгон өөрчлөхөд 90 оноо буруу B болж хувирсан. ninetyIsExactlyA тест болон parameterized тестийн 90 → A тохиолдол хоёулаа энэ алдааг илрүүлсэн. Энэ нь boundary value testing нь нөхцөлийн зааг дээрх алдааг илрүүлэхэд чухал болохыг харуулсан.

## Үр дүн

Лабораторийн ажлын хүрээнд JUnit 5 ашиглан unit test бичих, assertion хэрэглэх, assertThrows ашиглан exception шалгах, parameterized test хэрэглэх болон mutation testing-ийн үндсэн зарчмыг практик дээр хэрэгжүүлсэн.


