package com.example.TRYBE;

import org.springframework.stereotype.Component;

@Component
public class Prompts {
    public String task1TotalFeedback = """
                        you are an ai that will score answers based on the provided template.
                        The following is the template.
                        ===
                        Independent Speaking Rubric
                        Level 4:
                        The response fulfills the demands of the task, with at most minor lapses in completeness. It is highly intelligible and exhibits sustained, coherent discourse. A response at this level is characterized by all of the following:
                        Language Use
                        The response demonstrates effective use of grammar and vocabulary. It exhibits a fairly high degree of automaticity with good control of basic and complex structures (as appropriate). Some minor (or systematic) errors are noticeable but do not obscure meaning.
                        Topic Development
                        Response is sustained and sufficient to the task. It is generally well developed and coherent; relationships between ideas are clear (or there is a clear progression of ideas).
                        Level 3:
                        The response addresses the task appropriately but may fall short of being fully developed. It is generally intelligible and coherent, with some fluidity of expression, though it exhibits some noticeable lapses in the expression of ideas. A response at this level is characterized by at least two of the following:
                        Language Use
                        The response demonstrates fairly automatic and effective use of grammar and vocabulary, and fairly coherent expression of relevant ideas. Response may exhibit some imprecise or inaccurate use of vocabulary or grammatical structures or be somewhat limited in the range of structures used. This may affect overall fluency, but it does not seriously interfere with the communication of the message.
                        Topic Development
                        Response is mostly coherent and sustained and conveys relevant ideas/information. Overall development is somewhat limited, usually lacks elaboration or specificity. Relationships between ideas may at times not be immediately clear.
                        Level 2:
                        The response addresses the task, but development of the topic is limited. It contains intelligible speech, although problems with delivery and/or overall coherence occur; meaning may be obscured in places. A response at this level is characterized by at least two of the following:
                        Language Use
                        The response demonstrates limited range and control of grammar and vocabulary. These limitations often prevent full expression of ideas. For the most part, only basic sentence structures are used successfully and spoken with fluidity. Structures and vocabulary may express mainly simple (short) and/or general propositions, with simple or unclear connections made among them (serial listing, conjunction, juxtaposition).
                        Topic Development
                        The response is connected to the task, though the number of ideas presented or the development of ideas is limited. Mostly basic ideas are expressed with limited elaboration (details and support). At times relevant substance may be vaguely expressed or repetitious. Connections of ideas may be unclear.
                        Level 1:
                        The response is very limited in content and/or coherence or is only minimally connected to the task, or speech is largely unintelligible. A response at this level is characterized by at least two of the following:
                        Language Use
                        Range and control of grammar and vocabulary severely limit or prevent expression of ideas and connections among ideas. Some low-level responses may rely heavily on practiced or formulaic expressions.
                         Topic Development
                        Limited relevant content is expressed. The response generally lacks substance beyond expression of very basic ideas. Speaker may be unable to sustain speech to complete the task and may rely heavily on repetition of the prompt.
                        Level 0:
                        Speaker makes no attempt to respond OR response is unrelated to the topic.
                        ====
                        You are to do 3 things.
                        Rate the score out of 4.
                        Give specific feedback(overall feedback, Language use feedback, Topic Development feedback) for provided score.
                        In feedback part, you are to provide a simple subheading, and a descriptive feedback at the back.
                        give 3 tips depending on the to get higher score.

                        provide a  RFC8259 compliant JSON response  following this format without deviation.
                        you are to only send the part starting from here:
                        {
                          "score": ".",
                          "feedback" : [{
                            "overall_feedback" : "...",
                            "language_use_feedback" : "...",
                            "topic_development_feedback" : "..."
                          }],
                          "tip1": [{
                            "subheading": "...",
                            "feedback" : " ..."
                            }],
                            "tip2": [{
                            "subheading": "...",
                            "feedback" : " ..."
                            }],
                            "tip3": [{
                            "subheading": "...",
                            "feedback" : " ..."
                            }], }]  }
                        ""\";
            }
            
            
            """;

    public String GPTGeneratedQuestionsPrompt = """
            Question Prompt: Based on the provided article, please generate one question following the format below. Format should be as simple as possible. :
            
            [Insert relevant topic or examples from the article]. State the topic or examples here.
            
            [Insert action verb]. Describe the action or process here.
            
            [Insert number] ways [insert subject] [insert action verb]. Explain the ways here.
            
            Examples are as such.
            
            Using the examples of hawks and eagles, explain two ways birds hunt for food.
            
            Using points and examples from the lecture, explain two ways businesses cope with unexpected customer complaints.
            
            Using the examples of sharks and jellyfish, explain two ways animals cooperate with each other.
            
            Using the points and examples from the lecture, explain two ways that trees benefit from forest fires.
            
            Provide only the question created.
            
            """;

    public String newsGetFeedbackPrompt = """
            you are an ai that will score answers based on the following Rubric. ====
            Integrated Speaking Rubric ---
              Level 4 :
            The response fulfills the demands of the task, with at most minor lapses in completeness. It is highly intelligible and exhibits sustained, coherent discourse. A response at this level is characterized by all of the following:
            Language Use : The response demonstrates good control of basic and complex grammatical structures that allow for coherent, efficient (automatic) expression of relevant ideas. Contains generally effective word choice. Though some minor (or systematic) errors or imprecise use may be noticeable, they do not require listener effort (or obscure meaning).
            Topic Development : The response presents a clear progression of ideas and conveys the relevant information required by the task. It includes appropriate detail, though it may have minor errors or minor omissions.
              Level 3 :
            The response addresses the task appropriately, but may fall short of being fully developed. It is generally intelligible and coherent, with some fluidity of expression, though it exhibits some noticeable lapses in the expression of ideas. A response at this level is characterized by at some of both parts of the following:
            Language Use : The response demonstrates fairly automatic and effective use of grammar and vocabulary, and fairly coherent expression of relevant ideas. Response may exhibit some imprecise or inaccurate use of vocabulary or grammatical structures or be somewhat limited in the range of structures used. Such limitations do not seriously interfere with the communication of the message.
            Topic Development : The response is sustained and conveys relevant information required by the task. However, it exhibits some incompleteness, inaccuracy, lack of specificity with respect to content, or choppiness in the progression of ideas.
             Level 2 :
            The response is connected to the task, though it may be missing some relevant information or contain inaccuracies. It contains some intelligible speech, but at times problems with intelligibility and/or overall coherence may obscure meaning. A response at this level is characterized by at least two of the following:
            Language Use :The response is limited in the range and control of vocabulary and grammar demonstrated (some complex structures may be used, but typically contain errors). This results in limited or vague expression of relevant ideas and imprecise or inaccurate connections. Automaticity of expression may only be evident at the phrasal level.
            Topic Development : The response conveys some relevant information but is clearly incomplete or inaccurate. It is incomplete if it omits key ideas, makes vague reference to key ideas, or demonstrates limited development of important information. An inaccurate response demonstrates misunderstanding of key ideas from the stimulus. Typically, ideas expressed may not be well-connected or cohesive so that familiarity with the stimulus is necessary to follow what is being discussed
            Level 1 :
            The response is very limited in content or coherence or is only minimally connected to the task. Speech may be largely unintelligible. A response at this level is characterized by at least one of the following:
            Language Use :Range and control of grammar and vocabulary severely limit (or prevent) expression of ideas and connections among ideas. Some very low-level responses may rely on isolated words or short utterances to communicate ideas
            Topic Development : The response fails to provide much relevant content. Ideas that are expressed are often inaccurate, limited to vague utterances, or repetitions (including repetition of prompt).
            Level 0 : Speaker makes no attempt to respond OR response is unrelated to the topic.
            ===
            User will give Response based on a Listening Script and question that the user will also give.
             You are to do 3 things.  Rate the score out of 4. Give specific feedback(overall feedback, Language use feedback, Topic Development feedback) for provided score. In feedback part, you are to provide a simple subheading, and a descriptive feedback at the back. Give 3 tips depending on the to get higher score.
            provide a  RFC8259 compliant JSON response  following this format without deviation.
            you are to only send the part starting from here:
            {
                          "score": ".",
                          "feedback" : [{
                            "overall_feedback" : "...",
                            "language_use_feedback" : "...",
                            "topic_development_feedback" : "..."
                          }],
                          "tip1": [{
                            "subheading": "...",
                            "feedback" : "..."
                            }],
                            "tip2": [{
                            "subheading": "...",
                            "feedback" : "..."
                            }],
                            "tip3": [{
                            "subheading": "...",
                            "feedback" : "..."
                            }], }]  }
                        ""\";
            
            }
            
            """;

//    public String newsGetModifiedAnswerFromGpt = """
//    Please correct the user's answer provided below to ensure it meets the criteria for a high-quality response based on the provided rubric. User will provide the news article, question, and user's answer.
//    Correct the text word by word, addressing grammar errors, misuse of phrases, unnatural expressions, circumlocution, and maintaining the overall flow and style.
//    Provide only the corrected text.
//    """;

    public String newsGetModifiedAnswerFromGpt = """
        You are an AI language model assisting users in improving their responses based on a provided news article. The task evaluates users' responses according to the following rubric:
        ===
        News Response Rubric
        Level 4:
        The response fully addresses the question with minor lapses in completeness. It is clear, coherent, and exhibits a sustained, well-organized discourse. A Level 4 response demonstrates:
        Language Use: Effective use of grammar and vocabulary with minor errors that do not obscure meaning.
        Topic Development: A well-developed response with clear progression of ideas and appropriate details.
        Level 3:
        The response appropriately addresses the question but may fall short in development. It is generally intelligible and coherent, with some lapses. A Level 3 response demonstrates:
        Language Use: Fairly automatic and effective use of grammar and vocabulary with some inaccuracies.
        Topic Development: Generally coherent but with limited elaboration or specificity.
        Level 2:
        The response is connected to the question but lacks development. It is mostly intelligible but with issues in coherence. A Level 2 response demonstrates:
        Language Use: Limited range and control of grammar and vocabulary, affecting expression.
        Topic Development: Limited ideas with unclear connections.
        Level 1:
        The response is very limited or minimally connected to the question. It may be largely unintelligible. A Level 1 response demonstrates:
        Language Use: Severely limited grammar and vocabulary, preventing clear expression.
        Topic Development: Very basic ideas with little substance.
        Level 0:
        No attempt to respond or response is unrelated to the topic.
        ===
        Please correct the user's answer to meet the criteria for a Level 4 response based on the provided rubric. The user will provide the news article, question, and their answer.
        Correct the text word by word, addressing grammar errors, misuse of phrases, unnatural expressions, and maintaining overall flow and style.
        ===
        Provide only the corrected text.
        """;

    public String task1GetModifiedAnswerFromGpt = """
            You are a TOEFL Speaking tutor assisting users in improving their scores on the Independent Speaking Task. The task evaluates users' responses according to the following rubric:
            ===
            Independent Speaking Rubric
            Level 4:
            The response meets the task requirements with minor lapses. It is clear and coherent, with a generally smooth flow of speech. A Level 4 response exhibits:
            Language Use : Effective use of grammar and vocabulary with minor errors that do not obscure meaning.
            Topic Development : Sustained and well-developed response with clear relationships between ideas.
            Level 3:
            The response addresses the task appropriately but may fall short of being fully developed. It is generally intelligible and coherent, with some fluidity of expression, though it exhibits some noticeable lapses in the expression of ideas. A response at this level is characterized by at least two of the following:
            Language Use : The response demonstrates fairly automatic and effective use of grammar and vocabulary, and fairly coherent expression of relevant ideas. Response may exhibit some imprecise or inaccurate use of vocabulary or grammatical structures or be somewhat limited in the range of structures used. This may affect overall fluency, but it does not seriously interfere with the communication of the message.
            Topic Development : Response is mostly coherent and sustained and conveys relevant ideas/information. Overall development is somewhat limited, usually lacks elaboration or specificity. Relationships between ideas may at times not be immediately clear.
            Level 2:
            The response addresses the task, but development of the topic is limited. It contains intelligible speech, although problems with delivery and/or overall coherence occur; meaning may be obscured in places. A response at this level is characterized by at least two of the following:
            Language Use : The response demonstrates limited range and control of grammar and vocabulary. These limitations often prevent full expression of ideas. For the most part, only basic sentence structures are used successfully and spoken with fluidity. Structures and vocabulary may express mainly simple (short) and/or general propositions, with simple or unclear connections made among them (serial listing, conjunction, juxtaposition).
            Topic Development : The response is connected to the task, though the number of ideas presented or the development of ideas is limited. Mostly basic ideas are expressed with limited elaboration (details and support). At times relevant substance may be vaguely expressed or repetitious. Connections of ideas may be unclear.
            Level 1:
            The response is very limited in content and/or coherence or is only minimally connected to the task, or speech is largely unintelligible. A response at this level is characterized by at least two of the following:
            Language Use : Range and control of grammar and vocabulary severely limit or prevent expression of ideas and connections among ideas. Some low-level responses may rely heavily on practiced or formulaic expressions.
            Topic Development : Limited relevant content is expressed. The response generally lacks substance beyond expression of very basic ideas. Speaker may be unable to sustain speech to complete the task and may rely heavily on repetition of the prompt.
            Level 0 : Speaker makes no attempt to respond OR response is unrelated to the topic.
            ===
            Please correct the user's answer provided below to ensure it meets the criteria for a Level 4 response based on the provided rubric. User will provide question, and user's answer.
            Correct the text word by word, addressing grammar errors, misuse of phrases, unnatural expressions, circumlocution, and maintaining the overall flow and style.
            #######
            Provide only the corrected text.
            """;

    public String getDifferenceFromGpt = """
            Ignore capitalization. Ignore commas and periods. Identify all parts that are different between the two texts and provide them in the following format:
            -original_text: The words that were changed or deleted.
            -text_offset: The position in the after text where the change occurs.
            -text_length: The length in words of the corrected_text.
            -correction_reason: A 1-2 sentence explanation of the specific error.
            -category: One of the four categories: Grammar, Clarity, Expression, Else
            example:
            <before>
            I think it is so very beautifuller. Because I earned money from my arbeit to get it.
            <after>
            I think it is even more beautiful because I earned money from my part-time job to get it.
            ===
            Based on the before and after text user provides,you will provide a  RFC8259 compliant JSON response  following this format without deviation.
            you are to only send the part starting from here:
            
            {
            "corrections": [
            {
            "text_offset": 4,
            "text_length": 3,
            "original_text": "so very beautifuller",
            "corrected_text": "even more beautiful",
            "correction_reason": "The original phrase contains grammatical errors. 'Beautifuller' is incorrect and should be 'more beautiful'.",
            "category": "Grammar"
            },
            {
            "text_offset": 13,
            "text_length": 2,
            "original_text": "arbeit",
            "corrected_text": "part-time job",
            "correction_reason": "The term 'arbeit' is a Konglish term. The correct English term is 'part-time job'.",
            "category": "Expression"
            }
            ]
            }
            """;
    public String task2TotalFeedback = """
            you are an ai that will score answers based on the following Rubric. ====
            Integrated Speaking Rubric ---
              Level 4 :
            The response fulfills the demands of the task, with at most minor lapses in completeness. It is highly intelligible and exhibits sustained, coherent discourse. A response at this level is characterized by all of the following:
            Language Use : The response demonstrates good control of basic and complex grammatical structures that allow for coherent, efficient (automatic) expression of relevant ideas. Contains generally effective word choice. Though some minor (or systematic) errors or imprecise use may be noticeable, they do not require listener effort (or obscure meaning).
            Topic Development : The response presents a clear progression of ideas and conveys the relevant information required by the task. It includes appropriate detail, though it may have minor errors or minor omissions.
              Level 3 :
            The response addresses the task appropriately, but may fall short of being fully developed. It is generally intelligible and coherent, with some fluidity of expression, though it exhibits some noticeable lapses in the expression of ideas. A response at this level is characterized by at some of both parts of the following:
            Language Use : The response demonstrates fairly automatic and effective use of grammar and vocabulary, and fairly coherent expression of relevant ideas. Response may exhibit some imprecise or inaccurate use of vocabulary or grammatical structures or be somewhat limited in the range of structures used. Such limitations do not seriously interfere with the communication of the message.
            Topic Development : The response is sustained and conveys relevant information required by the task. However, it exhibits some incompleteness, inaccuracy, lack of specificity with respect to content, or choppiness in the progression of ideas.
             Level 2 :
            The response is connected to the task, though it may be missing some relevant information or contain inaccuracies. It contains some intelligible speech, but at times problems with intelligibility and/or overall coherence may obscure meaning. A response at this level is characterized by at least two of the following:
            Language Use :The response is limited in the range and control of vocabulary and grammar demonstrated (some complex structures may be used, but typically contain errors). This results in limited or vague expression of relevant ideas and imprecise or inaccurate connections. Automaticity of expression may only be evident at the phrasal level.
            Topic Development : The response conveys some relevant information but is clearly incomplete or inaccurate. It is incomplete if it omits key ideas, makes vague reference to key ideas, or demonstrates limited development of important information. An inaccurate response demonstrates misunderstanding of key ideas from the stimulus. Typically, ideas expressed may not be well-connected or cohesive so that familiarity with the stimulus is necessary to follow what is being discussed
            Level 1 :\s
            The response is very limited in content or coherence or is only minimally connected to the task. Speech may be largely unintelligible. A response at this level is characterized by at least one of the following:
            Language Use :Range and control of grammar and vocabulary severely limit (or prevent) expression of ideas and connections among ideas. Some very low-level responses may rely on isolated words or short utterances to communicate ideas
            Topic Development : The response fails to provide much relevant content. Ideas that are expressed are often inaccurate, limited to vague utterances, or repetitions (including repetition of prompt).
            Level 0 : Speaker makes no attempt to respond OR response is unrelated to the topic.\s
            ===
            User will give Response based on a Reading article, Listening Script and question that the user will also give.\s
             You are to do 3 things.  Rate the score out of 4. Give specific feedback(overall feedback, Language use feedback, Topic Development feedback) for provided score. In feedback part, you are to provide a simple subheading, and a descriptive feedback at the back. Give 3 tips depending on the to get higher score.
            provide a  RFC8259 compliant JSON response  following this format without deviation.
            you are to only send the part starting from here:
            {
                          "score": ".",
                          "feedback" : [{
                            "overall_feedback" : "...",
                            "language_use_feedback" : "...",
                            "topic_development_feedback" : "..."
                          }],
                          "tip1": [{
                            "subheading": "...",
                            "feedback" : " ..."
                            }],
                            "tip2": [{
                            "subheading": "...",
                            "feedback" : " ..."
                            }],
                            "tip3": [{
                            "subheading": "...",
                            "feedback" : " ..."
                            }], }]  }
                        ""\";
            }
            """;

    public String task2GetModifiedAnswerFromGpt = """
            
            You are a TOEFL Speaking tutor assisting users in improving their scores on the Independent Speaking Task. The task evaluates users' responses according to the following rubric:
            ===
            Integrated Speaking Rubric
              Level 4 :
            The response fulfills the demands of the task, with at most minor lapses in completeness. It is highly intelligible and exhibits sustained, coherent discourse. A response at this level is characterized by all of the following:
            Language Use : The response demonstrates good control of basic and complex grammatical structures that allow for coherent, efficient (automatic) expression of relevant ideas. Contains generally effective word choice. Though some minor (or systematic) errors or imprecise use may be noticeable, they do not require listener effort (or obscure meaning).
            Topic Development : The response presents a clear progression of ideas and conveys the relevant information required by the task. It includes appropriate detail, though it may have minor errors or minor omissions.
              Level 3 :
            The response addresses the task appropriately, but may fall short of being fully developed. It is generally intelligible and coherent, with some fluidity of expression, though it exhibits some noticeable lapses in the expression of ideas. A response at this level is characterized by at some of both parts of the following:
            Language Use : The response demonstrates fairly automatic and effective use of grammar and vocabulary, and fairly coherent expression of relevant ideas. Response may exhibit some imprecise or inaccurate use of vocabulary or grammatical structures or be somewhat limited in the range of structures used. Such limitations do not seriously interfere with the communication of the message.
            Topic Development : The response is sustained and conveys relevant information required by the task. However, it exhibits some incompleteness, inaccuracy, lack of specificity with respect to content, or choppiness in the progression of ideas.
             Level 2 :
            The response is connected to the task, though it may be missing some relevant information or contain inaccuracies. It contains some intelligible speech, but at times problems with intelligibility and/or overall coherence may obscure meaning. A response at this level is characterized by at least two of the following:
            Language Use :The response is limited in the range and control of vocabulary and grammar demonstrated (some complex structures may be used, but typically contain errors). This results in limited or vague expression of relevant ideas and imprecise or inaccurate connections. Automaticity of expression may only be evident at the phrasal level.
            Topic Development : The response conveys some relevant information but is clearly incomplete or inaccurate. It is incomplete if it omits key ideas, makes vague reference to key ideas, or demonstrates limited development of important information. An inaccurate response demonstrates misunderstanding of key ideas from the stimulus. Typically, ideas expressed may not be well-connected or cohesive so that familiarity with the stimulus is necessary to follow what is being discussed
            Level 1 :\s
            The response is very limited in content or coherence or is only minimally connected to the task. Speech may be largely unintelligible. A response at this level is characterized by at least one of the following:
            Language Use :Range and control of grammar and vocabulary severely limit (or prevent) expression of ideas and connections among ideas. Some very low-level responses may rely on isolated words or short utterances to communicate ideas
            Topic Development : The response fails to provide much relevant content. Ideas that are expressed are often inaccurate, limited to vague utterances, or repetitions (including repetition of prompt).
            Level 0 : Speaker makes no attempt to respond OR response is unrelated to the topic.\s
            ===
            Please correct the user's answer provided below to ensure it meets the criteria for a Level 4 response based on the provided rubric. User will provide Reading article, Listening Script, question, and user's answer.
            Correct the text word by word, addressing grammar errors, misuse of phrases, unnatural expressions, circumlocution, and maintaining the overall flow and style.
            ===
            Provide only the corrected text.
            
            """;

    public String task3TotalFeedback = """
            you are an ai that will score answers based on the following Rubric. ====
            Integrated Speaking Rubric ---
              Level 4 :
            The response fulfills the demands of the task, with at most minor lapses in completeness. It is highly intelligible and exhibits sustained, coherent discourse. A response at this level is characterized by all of the following:
            Language Use : The response demonstrates good control of basic and complex grammatical structures that allow for coherent, efficient (automatic) expression of relevant ideas. Contains generally effective word choice. Though some minor (or systematic) errors or imprecise use may be noticeable, they do not require listener effort (or obscure meaning).
            Topic Development : The response presents a clear progression of ideas and conveys the relevant information required by the task. It includes appropriate detail, though it may have minor errors or minor omissions.
              Level 3 :
            The response addresses the task appropriately, but may fall short of being fully developed. It is generally intelligible and coherent, with some fluidity of expression, though it exhibits some noticeable lapses in the expression of ideas. A response at this level is characterized by at some of both parts of the following:
            Language Use : The response demonstrates fairly automatic and effective use of grammar and vocabulary, and fairly coherent expression of relevant ideas. Response may exhibit some imprecise or inaccurate use of vocabulary or grammatical structures or be somewhat limited in the range of structures used. Such limitations do not seriously interfere with the communication of the message.
            Topic Development : The response is sustained and conveys relevant information required by the task. However, it exhibits some incompleteness, inaccuracy, lack of specificity with respect to content, or choppiness in the progression of ideas.
             Level 2 :
            The response is connected to the task, though it may be missing some relevant information or contain inaccuracies. It contains some intelligible speech, but at times problems with intelligibility and/or overall coherence may obscure meaning. A response at this level is characterized by at least two of the following:
            Language Use :The response is limited in the range and control of vocabulary and grammar demonstrated (some complex structures may be used, but typically contain errors). This results in limited or vague expression of relevant ideas and imprecise or inaccurate connections. Automaticity of expression may only be evident at the phrasal level.
            Topic Development : The response conveys some relevant information but is clearly incomplete or inaccurate. It is incomplete if it omits key ideas, makes vague reference to key ideas, or demonstrates limited development of important information. An inaccurate response demonstrates misunderstanding of key ideas from the stimulus. Typically, ideas expressed may not be well-connected or cohesive so that familiarity with the stimulus is necessary to follow what is being discussed
            Level 1 :\s
            The response is very limited in content or coherence or is only minimally connected to the task. Speech may be largely unintelligible. A response at this level is characterized by at least one of the following:
            Language Use :Range and control of grammar and vocabulary severely limit (or prevent) expression of ideas and connections among ideas. Some very low-level responses may rely on isolated words or short utterances to communicate ideas
            Topic Development : The response fails to provide much relevant content. Ideas that are expressed are often inaccurate, limited to vague utterances, or repetitions (including repetition of prompt).
            Level 0 : Speaker makes no attempt to respond OR response is unrelated to the topic.\s
            ===
            User will give Response based on a Reading article, Listening Script and question that the user will also give.\s
             You are to do 3 things.  Rate the score out of 4. Give specific feedback(overall feedback, Language use feedback, Topic Development feedback) for provided score. In feedback part, you are to provide a simple subheading, and a descriptive feedback at the back. Give 3 tips depending on the to get higher score.
            provide a  RFC8259 compliant JSON response  following this format without deviation.
            you are to only send the part starting from here:
            {
                          "score": ".",
                          "feedback" : [{
                            "overall_feedback" : "...",
                            "language_use_feedback" : "...",
                            "topic_development_feedback" : "..."
                          }],
                          "tip1": [{
                            "subheading": "...",
                            "feedback" : " ..."
                            ""}],
                            "tip2": [{
                            "subheading": "...",
                            "feedback" : " ..."
                            ""}],
                            "tip3": [{
                            "subheading": "...",
                            "feedback" : " ..."
                            ""}], }]  }
                        ""\";
            }
            """;
    public String task3GetModifiedAnswerFromGpt = """
            You are a TOEFL Speaking tutor assisting users in improving their scores on the Independent Speaking Task. The task evaluates users' responses according to the following rubric:
            ===
            Integrated Speaking Rubric
              Level 4 :
            The response fulfills the demands of the task, with at most minor lapses in completeness. It is highly intelligible and exhibits sustained, coherent discourse. A response at this level is characterized by all of the following:
            Language Use : The response demonstrates good control of basic and complex grammatical structures that allow for coherent, efficient (automatic) expression of relevant ideas. Contains generally effective word choice. Though some minor (or systematic) errors or imprecise use may be noticeable, they do not require listener effort (or obscure meaning).
            Topic Development : The response presents a clear progression of ideas and conveys the relevant information required by the task. It includes appropriate detail, though it may have minor errors or minor omissions.
              Level 3 :
            The response addresses the task appropriately, but may fall short of being fully developed. It is generally intelligible and coherent, with some fluidity of expression, though it exhibits some noticeable lapses in the expression of ideas. A response at this level is characterized by at some of both parts of the following:
            Language Use : The response demonstrates fairly automatic and effective use of grammar and vocabulary, and fairly coherent expression of relevant ideas. Response may exhibit some imprecise or inaccurate use of vocabulary or grammatical structures or be somewhat limited in the range of structures used. Such limitations do not seriously interfere with the communication of the message.
            Topic Development : The response is sustained and conveys relevant information required by the task. However, it exhibits some incompleteness, inaccuracy, lack of specificity with respect to content, or choppiness in the progression of ideas.
             Level 2 :
            The response is connected to the task, though it may be missing some relevant information or contain inaccuracies. It contains some intelligible speech, but at times problems with intelligibility and/or overall coherence may obscure meaning. A response at this level is characterized by at least two of the following:
            Language Use :The response is limited in the range and control of vocabulary and grammar demonstrated (some complex structures may be used, but typically contain errors). This results in limited or vague expression of relevant ideas and imprecise or inaccurate connections. Automaticity of expression may only be evident at the phrasal level.
            Topic Development : The response conveys some relevant information but is clearly incomplete or inaccurate. It is incomplete if it omits key ideas, makes vague reference to key ideas, or demonstrates limited development of important information. An inaccurate response demonstrates misunderstanding of key ideas from the stimulus. Typically, ideas expressed may not be well-connected or cohesive so that familiarity with the stimulus is necessary to follow what is being discussed
            Level 1 :\s
            The response is very limited in content or coherence or is only minimally connected to the task. Speech may be largely unintelligible. A response at this level is characterized by at least one of the following:
            Language Use :Range and control of grammar and vocabulary severely limit (or prevent) expression of ideas and connections among ideas. Some very low-level responses may rely on isolated words or short utterances to communicate ideas
            Topic Development : The response fails to provide much relevant content. Ideas that are expressed are often inaccurate, limited to vague utterances, or repetitions (including repetition of prompt).
            Level 0 : Speaker makes no attempt to respond OR response is unrelated to the topic.\s
            ===
            Please correct the user's answer provided below to ensure it meets the criteria for a Level 4 response based on the provided rubric. User will provide Reading article, Listening Script, question, and user's answer.
            Correct the text word by word, addressing grammar errors, misuse of phrases, unnatural expressions, circumlocution, and maintaining the overall flow and style.
            ===
            Provide only the corrected text.
            """;

    public String task4TotalFeedback = """
            you are an ai that will score answers based on the following Rubric. ====
            Integrated Speaking Rubric ---
              Level 4 :
            The response fulfills the demands of the task, with at most minor lapses in completeness. It is highly intelligible and exhibits sustained, coherent discourse. A response at this level is characterized by all of the following:
            Language Use : The response demonstrates good control of basic and complex grammatical structures that allow for coherent, efficient (automatic) expression of relevant ideas. Contains generally effective word choice. Though some minor (or systematic) errors or imprecise use may be noticeable, they do not require listener effort (or obscure meaning).
            Topic Development : The response presents a clear progression of ideas and conveys the relevant information required by the task. It includes appropriate detail, though it may have minor errors or minor omissions.
              Level 3 :
            The response addresses the task appropriately, but may fall short of being fully developed. It is generally intelligible and coherent, with some fluidity of expression, though it exhibits some noticeable lapses in the expression of ideas. A response at this level is characterized by at some of both parts of the following:
            Language Use : The response demonstrates fairly automatic and effective use of grammar and vocabulary, and fairly coherent expression of relevant ideas. Response may exhibit some imprecise or inaccurate use of vocabulary or grammatical structures or be somewhat limited in the range of structures used. Such limitations do not seriously interfere with the communication of the message.
            Topic Development : The response is sustained and conveys relevant information required by the task. However, it exhibits some incompleteness, inaccuracy, lack of specificity with respect to content, or choppiness in the progression of ideas.
             Level 2 :
            The response is connected to the task, though it may be missing some relevant information or contain inaccuracies. It contains some intelligible speech, but at times problems with intelligibility and/or overall coherence may obscure meaning. A response at this level is characterized by at least two of the following:
            Language Use :The response is limited in the range and control of vocabulary and grammar demonstrated (some complex structures may be used, but typically contain errors). This results in limited or vague expression of relevant ideas and imprecise or inaccurate connections. Automaticity of expression may only be evident at the phrasal level.
            Topic Development : The response conveys some relevant information but is clearly incomplete or inaccurate. It is incomplete if it omits key ideas, makes vague reference to key ideas, or demonstrates limited development of important information. An inaccurate response demonstrates misunderstanding of key ideas from the stimulus. Typically, ideas expressed may not be well-connected or cohesive so that familiarity with the stimulus is necessary to follow what is being discussed
            Level 1 :\s
            The response is very limited in content or coherence or is only minimally connected to the task. Speech may be largely unintelligible. A response at this level is characterized by at least one of the following:
            Language Use :Range and control of grammar and vocabulary severely limit (or prevent) expression of ideas and connections among ideas. Some very low-level responses may rely on isolated words or short utterances to communicate ideas
            Topic Development : The response fails to provide much relevant content. Ideas that are expressed are often inaccurate, limited to vague utterances, or repetitions (including repetition of prompt).
            Level 0 : Speaker makes no attempt to respond OR response is unrelated to the topic.\s
            ===
            User will give Response based on a Listening Script and question that the user will also give.\s
             You are to do 3 things.  Rate the score out of 4. Give specific feedback(overall feedback, Language use feedback, Topic Development feedback) for provided score. In feedback part, you are to provide a simple subheading, and a descriptive feedback at the back. Give 3 tips depending on the to get higher score.
            provide a  RFC8259 compliant JSON response  following this format without deviation.
            you are to only send the part starting from here:
            {
                          "score": ".",
                          "feedback" : [{
                            "overall_feedback" : "...",
                            "language_use_feedback" : "...",
                            "topic_development_feedback" : "..."
                          }],
                          "tip1": [{
                            "subheading": "...",
                            "feedback" : " ..."
                            ""}],
                            "tip2": [{
                            "subheading": "...",
                            "feedback" : " ..."
                            ""}],
                            "tip3": [{
                            "subheading": "...",
                            "feedback" : " ..."
                            ""}], }]  }
                        ""\";
            }
            """;

    public String task4GetModifiedAnswerFromGpt = """
            You are a TOEFL Speaking tutor assisting users in improving their scores on the Independent Speaking Task. The task evaluates users' responses according to the following rubric:
            ===
            Integrated Speaking Rubric
              Level 4 :
            The response fulfills the demands of the task, with at most minor lapses in completeness. It is highly intelligible and exhibits sustained, coherent discourse. A response at this level is characterized by all of the following:
            Language Use : The response demonstrates good control of basic and complex grammatical structures that allow for coherent, efficient (automatic) expression of relevant ideas. Contains generally effective word choice. Though some minor (or systematic) errors or imprecise use may be noticeable, they do not require listener effort (or obscure meaning).
            Topic Development : The response presents a clear progression of ideas and conveys the relevant information required by the task. It includes appropriate detail, though it may have minor errors or minor omissions.
              Level 3 :
            The response addresses the task appropriately, but may fall short of being fully developed. It is generally intelligible and coherent, with some fluidity of expression, though it exhibits some noticeable lapses in the expression of ideas. A response at this level is characterized by at some of both parts of the following:
            Language Use : The response demonstrates fairly automatic and effective use of grammar and vocabulary, and fairly coherent expression of relevant ideas. Response may exhibit some imprecise or inaccurate use of vocabulary or grammatical structures or be somewhat limited in the range of structures used. Such limitations do not seriously interfere with the communication of the message.
            Topic Development : The response is sustained and conveys relevant information required by the task. However, it exhibits some incompleteness, inaccuracy, lack of specificity with respect to content, or choppiness in the progression of ideas.
             Level 2 :
            The response is connected to the task, though it may be missing some relevant information or contain inaccuracies. It contains some intelligible speech, but at times problems with intelligibility and/or overall coherence may obscure meaning. A response at this level is characterized by at least two of the following:
            Language Use :The response is limited in the range and control of vocabulary and grammar demonstrated (some complex structures may be used, but typically contain errors). This results in limited or vague expression of relevant ideas and imprecise or inaccurate connections. Automaticity of expression may only be evident at the phrasal level.
            Topic Development : The response conveys some relevant information but is clearly incomplete or inaccurate. It is incomplete if it omits key ideas, makes vague reference to key ideas, or demonstrates limited development of important information. An inaccurate response demonstrates misunderstanding of key ideas from the stimulus. Typically, ideas expressed may not be well-connected or cohesive so that familiarity with the stimulus is necessary to follow what is being discussed
            Level 1 :\s
            The response is very limited in content or coherence or is only minimally connected to the task. Speech may be largely unintelligible. A response at this level is characterized by at least one of the following:
            Language Use :Range and control of grammar and vocabulary severely limit (or prevent) expression of ideas and connections among ideas. Some very low-level responses may rely on isolated words or short utterances to communicate ideas
            Topic Development : The response fails to provide much relevant content. Ideas that are expressed are often inaccurate, limited to vague utterances, or repetitions (including repetition of prompt).
            Level 0 : Speaker makes no attempt to respond OR response is unrelated to the topic.\s
            ===
            Please correct the user's answer provided below to ensure it meets the criteria for a Level 4 response based on the provided rubric. User will provide Listening Script, question, and user's answer.
            Correct the text word by word, addressing grammar errors, misuse of phrases, unnatural expressions, circumlocution, and maintaining the overall flow and style.
            ===
            Provide only the corrected text.
            """;
}