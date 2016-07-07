#include <iostream>
#include <stdlib.h>
#include <string.h>
using namespace std;

void removeDuplicates(char *input){
	int inputIndex = 0, resultIndex = 0;
	int *countArrayy = (int*)calloc(256,sizeof(int));
	for(int i=0;i<strlen(input);i++){
		if(countArrayy[input[i]]==0){
			input[resultIndex] = input[i];
			resultIndex++;
			countArrayy[input[i]]++;
		}
	}
	free(countArrayy);
	input[resultIndex] = '\0';
	cout<<input;
}

int main(){
	char *input;
	cin>>input;
	removeDuplicates(input);
	return 0;
}
