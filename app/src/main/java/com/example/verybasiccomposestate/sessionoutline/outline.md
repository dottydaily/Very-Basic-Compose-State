# Session Outline : Very Basic Compose State

- How Compose render UI? (Composition vs Initial compositon vs Recomposition)
- What is the "State" in Jetpack Compose?
- How to write a State?

## Q&A "Does Recomposition happen?" (Answer : Yes)

- Introduce "remember" function.
- A little detail on remember
  - How it contain state from recomposition
  - What happen to the state in remember if the owner (composable function) has exited the composition?
  - What happen to the state in remember if the app make a configuration changes?

## Q&A Is Remember function in Compose always use with a mutable value?

## Stateful vs Stateless

- What is Stateful / Stateless (Stateful is Composable function that own state, Stateless is the opposite of Stateful)
  - Which one is better?
  - How to convert Stateful to Stateless?
  - Explain what is this approach call?

## Example (In `answer` branch)

- Card view
- Car animation. (Sneak peak of how to do an Animation in Compose) (CarAnimation.kt)
- Extra : State hosting in ViewModel
- Extra : Convert LiveData to State.
