import java.util.*;
import java.util.function.Function;

class DecodeChar implements Function<Character, Character> {
  ArrayList<Character> alphabet;
  ArrayList<Character> code;

  DecodeChar(ArrayList<Character> alphabet, ArrayList<Character> code) {
    this.alphabet = alphabet;
    this.code = code;
  }

  // returns the character at the same index of the given is in the code
  public Character apply(Character t) {
    return this.alphabet.get(this.code.indexOf(t));
  }
}
