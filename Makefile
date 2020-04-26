app = excel
jar = build/libs/excel-1.0-SNAPSHOT-all.jar

$(app): $(jar)
	native-image --report-unsupported-elements-at-runtime -jar $(jar) $(app) --no-server

$(jar):
	./gradlew build

clean:
	rm $(app) $(jar)
