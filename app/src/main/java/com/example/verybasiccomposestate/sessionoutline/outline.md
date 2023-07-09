# Session Outline : Very Basic Compose State

- How Compose render UI? (Composition vs Recomposition)
- What is the "State" in Jetpack Compose?
- How to write a State?
  - Show example of the Composable function which isn't using State.
  - Try using State without remember.

## Q&A "Does Recomposition happen?"

- Introduce "remember" function.
- A little detail on remember
  - How it contain state from recomposition
  - What happen to the state in remember if the owner (composable function) has exited the composition?
  - What happen to the state in remember if the app make a configuration changes?

## Stateful vs Stateless

- What is Stateful / Stateless
  - Which one is better?
  - How to convert Stateful to Stateless?
  - Explain what is this approach call?

## Example

- Card view
- Car animation. (Sneak peak of how to do an Animation in Compose)
- Extra : State hosting in ViewModel.