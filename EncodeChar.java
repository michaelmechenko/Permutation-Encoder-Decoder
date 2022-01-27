import java.util.*;
import java.util.function.Function;

public class EncodeChar implements Function<Character, Character> {
  ArrayList<Character> alphabet;
  ArrayList<Character> code;

  EncodeChar(ArrayList<Character> alphabet, ArrayList<Character> code) {
    this.alphabet = alphabet;
    this.code = code;
  }

  // returns the character at the same index of the given is in the alphabet
  public Character apply(Character t) {
    return this.code.get(this.alphabet.indexOf(t));
  }
}