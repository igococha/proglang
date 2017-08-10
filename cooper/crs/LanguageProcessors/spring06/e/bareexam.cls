\ProvidesClass{cityexam}

\typeout{Style 'Bare City exam'. V1. March 2004 (David Bolton)} 

\ProcessOptions

\LoadClass[11pt]{article}
%\LoadClass[11pt,fleqn]{article}

\RequirePackage{a4wide}	% save some paper
\RequirePackage{ifthen}
%\RequirePackage{boxedminipage}
\RequirePackage{times}

% V5 made examnumber optional so can leave off safely. 
% Removed fleqn from LoadClass.

% V4 Added model answers stuff, ripped off from Paul Kelly and comments
% stuff from Sergio Almeida.


%%%%%%%%%%%----- Attempt model answers stuff -----%%%%%%%%%%%%5
%%       
%% Uses Sergio Almeida's comments:
% comment.sty   Paulo Sergio Almeida   29-Nov-96

%   Style for commenting portions of a document.
%
%   \comment{name}
%
%   Makes everything beetwen \begin{name} and \end{name} to be ignored.
%   Several names can behave as comments at the same time.
%   `name' can be chosen arbitrarily: either previously defined environments
%   or new names.
%   
%
%   IMPORTANT: comments with a given name DO NOT NEST.
%              It means this command is not much appropriate to comment
%              things like \begin{itemize} ... \end{itemize} which are
%              commonly nested.
%
%   Example of usage:
%
%   \documentstyle[...,comment,...]{...}
%   ...
%   \comment{abstract}
%   \comment{mycomment}
%   \comment{figure}
%
%   \begin{abstract}
%   ...
%   \end{abstract}
%
%   \begin{mycomment}
%   ...
%   \end{mycomment}
%
%   \begin{figure}
%   ...
%   \end{figure}
%
%   This removes the abstract, mycomments, and figures.

\begingroup \catcode`|=0 \catcode`[= 1
  \catcode`]=2 \catcode`\{=12 \catcode`\}=12
  \catcode`\\=12
  |gdef|set@skip#1[|def|skip##1\end{#1}[|end[#1]]]
|endgroup

\def\comment#1{
  \expandafter\def\csname #1\endcsname%
     {\set@skip{#1} \let\do\@makeother \dospecials \catcode`\^^M=12 \skip}
  \expandafter\def\csname end#1\endcsname{}
}
%%% end of inclusion of Sergio Almeida's comments


\def\emptymeansdefault{} % this empty means default model answers ie none
\def\solutionsprint{}    % used to signal model answers on paper
\def\examnumberprint{}   % used to signal exam number to be printed on paper

\newenvironment{modelanswer}%
 {\bgroup \small \begin{itemize}\sf \item[\bsolglyph\hspace{0.6in}] }%
 {\end{itemize} \esolglyph \egroup}

\newcommand{\withmodelanswers}{%
  \typeout{...WILL BE PRINTED WITH MODEL ANSWERS}%
  \def\emptymeansdefault{NOTEMPTY}%
  \def\solutionsprint{\fbox{\large\bf Warning: Model Answers Included}}  %% Used in title page and page footer to say model answers included
}

\newcommand{\withoutmodelanswers}{%
  \comment{modelanswer}%% This prevents modelanswer envt from appearing
  \def\emptymeansdefault{NOTEMPTY}%
  \typeout{...will be printed without model answers}%
}

%% bracket-like things to make model answer part appear separate on the page:
%%

\newcommand{\bsolglyph}{\raisebox{0ex}[0ex][0ex]{{\sf Answer}:\rule[-13pt]{1pt}{20pt}\rule[1.5ex]{20pt}{1pt}}}
\newcommand{\esolglyph}{~\hfill\raisebox{0ex}[0ex][0ex]{\rule[-0.5ex]{0.5in}{1pt}\rule[-0.5ex]{1pt}{1.5ex}}}


%%%%%%%%%%----- END MODEL ANSWERS DEFS ------%%%%%%%%%%%

% Removed lots of stuff to make bare paper.

%\topmargin -0.6 in     % For exam number to start at.

%\newsavebox{\theexamnumber}    % Saved in \examnumber, used in \examnumfoot.

% Fixed to sort out `marginpar not allowed as first element of
% paragraph' - 14/3/91.

%\newcommand{\examnumber}[1]{\sbox{\theexamnumber}{#1}%
%\def\examnumberprint{NOTEMPTY}}


%\def\examnumfoot#1{\@examnumfoot{\@nameuse{c@#1}}}  % Lifted from latex.tex
%\def\@examnumfoot#1{%
%\ifx\@empty\solutionsprint \relax \else \solutionsprint\ \fi%
%\ifx\@empty\examnumberprint \relax \else {\large \usebox{\theexamnumber}}\ \fi%
%\large (\number #1)}  % arabic stuff.
%\pagenumbering{examnumfoot}

    
\oddsidemargin  0 pt	%   Left margin on odd-numbered pages.
\evensidemargin 0 pt	%   Left margin on even-numbered pages.
\marginparwidth 1 in 	%   Width of marginal notes.
\textwidth 6 in		%   Width of text line.
\textheight 9.5 in


%\newenvironment{preamble}%
%{\thispagestyle{empty}\begin{center}\vspace*{-0.4in}\begin{center}{\LARGE\bf THE CITY UNIVERSITY\ifx\@empty\solutionsprint \relax \else \\[0.1in]\solutionsprint\fi}\\[0.05in]{\small\bf LONDON}\end{center}%
%\ifx\@empty\examnumberprint \vspace*{0.15in} \else \marginpar{\vspace{-0.8in}\hspace{-1cm}\large\bf No: \usebox{\theexamnumber}}\fi}%
%{\end{center}}

%\def\degrees#1{#1\\[0.15in]}	% Separate with \\
%\def\part#1{PART #1 EXAMINATION\\[0.15in]}
%\def\paper#1{COMPUTER SCIENCE -- PAPER #1\\[0.15in]}
%\def\title#1{#1\\[0.15in]}
%\def\examdate#1{#1\hfill}
%\def\examtime#1{#1\\[0.2in]}
%\def\rubric#1{{\em #1}}		% Separate lines with \\

%\newsavebox{\theexternals}
\newsavebox{\theinternals}

% Nasty hack here to get model answers to work...

%\newcommand{\externals}[1]{\sbox{\theexternals}{\begin{minipage}[t]{0.5\textwidth}External examiners: \hfill\raggedleft #1\end{minipage}}}
\newcommand{\internals}[1]{\sbox{\theinternals}{\begin{minipage}[t]{0.3\textwidth}\  \hfill\raggedleft #1\end{minipage}}
\ifx\@empty\emptymeansdefault
  \typeout{Default is without model answers...use `\protect\withmodelanswers' to see them}
  \typeout{(...I don't think it writes them :->)}
  \comment{modelanswer}
 \else
   \relax
 \fi}

%\def\examsection#1{\begin{center}\underline{\em Section #1}\end{center}}

\newenvironment{questions}{\begin{enumerate}\vspace{-0.2in}}{\finishquestion\end{enumerate}\vfill\hfill\usebox{\theinternals}}
\newenvironment{subquestions}{\begin{enumerate}}{\end{enumerate}}
\newenvironment{subsubquestions}{\begin{enumerate}}{\end{enumerate}}

% Notice the negative vspace in questions that fixes up `Question 1'.
\newcommand{\question}{\finishquestion \vspace{0.2in}\item}
\newcommand{\subquestion}{\item}
\newcommand{\subsubquestion}{\item}

\newcommand{\finishquestion}{%
\ifnum\value{enumi}>0{\ifnum\value{totalmarks}=100{}\else
	{\typeout{}%
	\typeout{WARNING: Question \arabic{enumi} has \arabic{totalmarks} marks}%
	\typeout{}%
}\fi}\fi%
\setcounter{totalmarks}{0}%
}

\newcommand{\marks}[1]{\smallskip\hfill [#1]\addtocounter{totalmarks}{#1}}

\newcounter{totalmarks}
