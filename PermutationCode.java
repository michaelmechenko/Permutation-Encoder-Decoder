import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PermutationCode {
  // The original list of characters to be encoded
  ArrayList<Character> alphabet =
          new ArrayList<Character>(Arrays.asList(
                  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                  'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                  't', 'u', 'v', 'w', 'x', 'y', 'z'));

  ArrayList<Character> code = new ArrayList<Character>(26);

  // A random number generator
  Random rand = new Random();

  // Create a new instance of the encoder/decoder with a new permutation code 
  PermutationCode() {
    this.code = this.initEncoder();
  }

  // Create a new instance of the encoder/decoder with the given code 
  PermutationCode(ArrayList<Character> code) {
    this.code = code;
  }

  // map swap to characters in the list, using rand for index
  // Initialize the encoding permutation of the characters
  ArrayList<Character> initEncoder() {
    ArrayList<Character> alph = this.alphabet;

    for (int i = 0; i < 26; i = i + 1) {
      Character newChar = alph.get(this.rand.nextInt(alph.size()));
      alph.remove(newChar);
      this.code.add(newChar);
    }
    this.alphabet = new ArrayList<Character>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z'));
    return this.code;
  }

  // swap characters with given algorithm, i.e. swap first two chars, next two chars
  // produce an encoded String from the given String
  String encode(String source) {
    ArrayList<Character> aSource = new ArrayList<Character>();
    for (char c : source.toCharArray()) {
      aSource.add(c);
    }

    ArrayList<Character> result = new ArrayUtils().map(aSource,
            new EncodeChar(this.alphabet, this.code));

    StringBuilder finalResult = new StringBuilder(aSource.size());
    for (Character ch : result) {
      finalResult.append(ch);
    }

    return finalResult.toString();
  }

  // reverse of encode
  // produce a decoded String from the given String
  String decode(String code) {
    ArrayList<Character> aCode = new ArrayList<Character>();
    for (char c : code.toCharArray()) {
      aCode.add(c);
    }

    ArrayList<Character> result = new ArrayUtils().map(aCode,
            new DecodeChar(this.alphabet, this.code));

    StringBuilder finalResult = new StringBuilder(aCode.size());
    for (Character ch : result) {
      finalResult.append(ch);
    }

    return finalResult.toString();
  }
}