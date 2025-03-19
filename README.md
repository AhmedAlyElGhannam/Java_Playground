# Java_Playground

## Installing Oracle JDK-8 on Linux

1. Extract the included `.tar.gz`
1. Update your `PATH` variable in `.bashrc`.
	```bash
	PATH="path-to-jdk-bin-dir:$PATH"
	```
1. Source `.bashrc`.
1. Install deez libraries to make applets work.
	```bash
	sudo apt-get install libx11-6:i386
	sudo apt-get install libstdc++5:i386
	sudo apt-get install libxrender1:i386 libxtst6:i386 libxi6:i386
	```
1. Profit!


<!-- Button && TextArea -->