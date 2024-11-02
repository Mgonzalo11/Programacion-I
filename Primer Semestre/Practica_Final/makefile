P=Principal
MAIN_CLASS=aplicacion.$(P)
SRC_DIR=./src
OUT_DIR=bin
DOC_DIR=html
JAR_FILE = $(P).jar

compilar: limpiar
	mkdir -p $(OUT_DIR)
	find $(SRC_DIR) -name "*.java" | xargs javac -cp $(OUT_DIR) -d $(OUT_DIR)

manifest:
	@echo "Manifest-Version: 1.0" > manifest.txt
	@echo "Main-Class: $(MAIN_CLASS)" >> manifest.txt
	@echo "Class-Path: ." >> manifest.txt
	@echo "" >> manifest.txt	

jar: manifest compilar
	jar cvfm $(JAR_FILE) manifest.txt -C $(OUT_DIR) .

ejecutar: compilar
	java -cp $(OUT_DIR) $(MAIN_CLASS)

limpiar:
	rm -rf $(OUT_DIR)
	rm -rf $(DOC_DIR)
	rm -f $(JAR_FILE)
	rm -f manifest.txt

javadoc: compilar
	find $(SRC_DIR) -name "*.java" | xargs javadoc -d $(DOC_DIR) -encoding utf-8 -docencoding utf-8 -charset utf-8

debug: compilar
	find $(SRC_DIR) -name "*.java" | xargs javac -g -cp $(OUT_DIR) -d $(OUT_DIR)
	cd $(OUT_DIR); jdb -sourcepath ../$(SRC_DIR)

runjar: jar
	java -jar $(JAR_FILE)
