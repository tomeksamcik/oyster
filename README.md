# OysterCard test

## Running tests

`gradle clean test jacocoTestReport`

## Notes

- Application is using Java 11 as it's my default JDK 
- Test report is available after running tests in `build/reports/tests/test` directory
- Jacoco test report is available after running tests in `build/reports/jacoco/test/html` directory
- Code allows for trips through more then two (from and destination) stations that can span more then two zones
- My understanding fare rules was as follows -
    - `Any one zone outside zone 1` - One of the zones of all stations doesn't contain zone 1 (excludes stations with multiple zones including zone 1)
    - `Any two zones including zone 1` - Exactly two stations contain zone 1 (includes stations with multiple zones including zone 1)
    - `Any two zones excluding zone 1` - Exactly two stations don't contain zone 1 (excludes stations with multiple zones including zone 1)
    - `Any three zones` - Three distinct zones of all stations
- Main test is located in `src/test/java/oyster/OysterOperationsTest` 
- Code is not thread-safe, so not meant to run concurrently